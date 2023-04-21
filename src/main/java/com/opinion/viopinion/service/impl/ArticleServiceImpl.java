package com.opinion.viopinion.service.impl;

import com.opinion.viopinion.entity.dto.ArticleAndWebDto;
import com.opinion.viopinion.entity.dto.ArticleDto;
import com.opinion.viopinion.entity.dto.CoreWordsDto;
import com.opinion.viopinion.entity.vo.EventWebSenCountVo;
import com.opinion.viopinion.entity.vo.WebArticleCountVo;
import com.opinion.viopinion.repository.*;
import com.opinion.viopinion.service.ArticleService;
import com.opinion.viopinion.tool.Translate;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.pipeline.Annotation;
import vn.pipeline.VnCoreNLP;
import vn.pipeline.Word;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (Article)表服务实现类
 * @since 2022-03-06 11:52:32
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final WebRepository webRepository;
    private final MonthRepository monthRepository;
    private final ArticleAndWebRepository articleAndWebRepository;
    private final CoreWordsRepository coreWordsRepository;
    public ArticleServiceImpl(ArticleRepository articleRepository, WebRepository webRepository,
                              MonthRepository monthRepository, ArticleAndWebRepository articleAndWebRepository,
                              CoreWordsRepository coreWordsRepository) {
        this.articleRepository = articleRepository;
        this.webRepository = webRepository;
        this.monthRepository = monthRepository;
        this.articleAndWebRepository = articleAndWebRepository;
        this.coreWordsRepository = coreWordsRepository;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleDto queryById(Integer id) {
        return articleRepository.findArticleDtoById(id);
    }
    @Override
    public List<ArticleDto> queryByBody(String body){
        return articleRepository.findArticleDtoByBodyContaining(body);
    }

    /**
     * 分页查询
     *
     * @param pageNum 当前页数
     * @param pageSize 当前页数据量
     * @return 查询结果
     */
    @Override
    public Page<ArticleDto> queryByPage(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return articleRepository.findAll(pageable);
    }
    /**
     * 新增数据
     *
     * @param articleDto 实例对象
     */
    @Override
    public String insert(ArticleDto articleDto) {
        articleRepository.save(articleDto);
        return "Successfully added data";
    }
    /**
     * 修改数据
     *
     * @param articleDto 实例对象
     */
    @Override
    public String update(ArticleDto articleDto) {
        var reArticle = articleRepository.findArticleDtoById(articleDto.getId());
        if(!reArticle.toString().isEmpty()) {
            BeanUtils.copyProperties(articleDto, reArticle);
            articleRepository.save(reArticle);
            return "Successfully updated data";
        }
        return "Failed to update data, data with id " + articleDto.getId() + " does not exist";
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     */
    @Override
    public String deleteById(Integer id) {
        if(!articleRepository.findArticleDtoById(id).toString().isEmpty()) {
            articleRepository.deleteById(id);
            return "Successfully deleted data";
        }
        return "Failed to delete data, data with id " + id + " does not exist";
    }

    /**
     * 返回根据新闻社分别统计的文章的总数
     *
     * @return 新闻社文章数量
     */
    @Override
    public List<WebArticleCountVo> queryWebArticleSum() {
        List<WebArticleCountVo> webCount = new ArrayList<>();
        webRepository.findAll().forEach(w -> {
            var web = new WebArticleCountVo(null, null);
            web.setWebName(w.getWebName());
            web.setArticleCount(articleRepository.findArticleDtoByWebsiteId(w.getWebsiteId()).size());
            webCount.add(web);
        });
        return webCount;
    }

    /**
     * 新闻事件统计的预处理
     */
    @Override
    public void articleAndWebUpdate() {
        if(!articleAndWebRepository.findAll().isEmpty()) {
            articleAndWebRepository.deleteAll();
        }
        webRepository.findAll().forEach(w -> {
            var aw = new ArticleAndWebDto();
            aw.setWebName(w.getWebName());
            articleRepository.findArticleDtoByWebsiteId(w.getWebsiteId()).forEach(a -> {
                if (monthRepository.existsMontharticleDtoByMaId(a.getId())) {
                    aw.setSentiment(monthRepository.findMontharticleDtoByMaId(a.getId()).getSentiment());
                    aw.setMaId(monthRepository.findMontharticleDtoByMaId(a.getId()).getMaId());
                    aw.setMonthevent(monthRepository.findMontharticleDtoByMaId(a.getId()).getMonthevent());
                    articleAndWebRepository.save(aw);
                }
            });
        });
    }

    /**
     * 返回根据新闻社类别统计的文章下的正面态度和负面态度的总数
     *
     * @return 正面统计数量和负面统计数量
     */
    @Override
    public List<WebArticleCountVo> queryWebSenSum(Integer sentiment) {
        return articleAndWebRepository.findAll().stream()
                .filter(aw -> aw.getSentiment().equals(sentiment))
                .collect(Collectors.groupingBy(ArticleAndWebDto::getWebName, Collectors.counting()))
                .entrySet().stream().map(e -> {
                    var webArticleCountVo = new WebArticleCountVo(e.getKey(), Math.toIntExact(e.getValue()));
                    webArticleCountVo.setWebName(e.getKey());
                    webArticleCountVo.setArticleCount(Math.toIntExact(e.getValue()));
                    return webArticleCountVo;
                })
                .collect(Collectors.toList());
    }

    /**
     * 统计每个事件的各个新闻社的新闻数量(分正面和负面)
     *
     * @return 相关媒体正（负）面新闻数量
     */
    @Override
    public List<EventWebSenCountVo> queryWebSenEventSum(Integer monthevent, Integer sentiment) {
        return articleAndWebRepository.findArticleAndWebDtoByMontheventAndSentiment(monthevent, sentiment)
                .stream()
                .map(ArticleAndWebDto::getWebName)
                .collect(Collectors.groupingBy(Object::toString))
                .entrySet().stream().map(e -> {
                    var eventWebSenCountVo = new EventWebSenCountVo(e.getKey(), e.getValue().size());
                    eventWebSenCountVo.setWebName(e.getKey());
                    eventWebSenCountVo.setArticleCount(e.getValue().size());
                    return eventWebSenCountVo;
                })
                .collect(Collectors.toList());
    }

    /**
     * 新闻语料分词，词性标注，命名实体识别，以及依赖解析
     */
    @Override
    public String vnCoreNLPExecute(Integer first_num, Integer last_num) throws IOException {
        if(!coreWordsRepository.findAll().isEmpty()) {
            coreWordsRepository.deleteAllInBatch();
        }
        // “wseg”、“pos”、“ner”和“parse”分别指分词、pos标记、ner和依赖解析。
        String[] annotators = {"wseg", "pos", "ner"};
        VnCoreNLP pipeline = new VnCoreNLP(annotators);
        String str = articleRepository.findArticleDtoByIdBetween(first_num, last_num).stream()
                .map(ArticleDto::getBody)
                .collect(Collectors.toList()).toString();
        Annotation annotation = new Annotation(str);
        pipeline.annotate(annotation);
        coreWordsRepository.saveAll(annotation.getWords().stream().map(word -> {
            var w = new Word(word);
            var coreWordsDto = new CoreWordsDto();
            coreWordsDto.setVnWord(w.getForm());
            coreWordsDto.setPosTag(w.getPosTag());
            coreWordsDto.setNer(w.getNerLabel());
            return coreWordsDto;
        }).filter(w -> {
            // 过滤掉分词中的标点符号
            String regEx="[`~!@#$%^&*()+=|{}':;,\\[\\].<>/?！￥…（）—【】‘；：”“’。，、？a-zA-Z0-9]";
            return !w.getVnWord().matches(regEx);
        }).filter(w -> {
            // 过滤掉分词中的数字
            String regEx ="[^0-9]";
            return !w.getVnWord().matches(regEx);
        }).collect(Collectors.toList()));
        return "Preprocessing completed";
    }

    /**
     * 分词翻译(越南语转中文)
     */
    @Override
    public String translateTest() {
        Translate translate = new Translate();
        coreWordsRepository.saveAll(
            coreWordsRepository.findAll().stream()
                .peek(word -> {
                    try {
                        word.setCnWord(translate.translateText(word.getVnWord(),"auto","zh_cn"));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                }).collect(Collectors.toList()));
        return "Preprocessing completed";
    }
}
