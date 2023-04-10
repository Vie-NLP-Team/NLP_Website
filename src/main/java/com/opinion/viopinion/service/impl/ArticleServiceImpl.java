package com.opinion.viopinion.service.impl;

import com.opinion.viopinion.entity.dto.ArticleAndWebDto;
import com.opinion.viopinion.entity.dto.ArticleDto;
import com.opinion.viopinion.entity.vo.WebArticleCountVo;
import com.opinion.viopinion.entity.vo.WebArticleSenCountVo;
import com.opinion.viopinion.repository.ArticleAndWebRepository;
import com.opinion.viopinion.repository.ArticleRepository;
import com.opinion.viopinion.repository.MonthRepository;
import com.opinion.viopinion.repository.WebRepository;
import com.opinion.viopinion.service.ArticleService;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
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
    public ArticleServiceImpl(ArticleRepository articleRepository, WebRepository webRepository,
                              MonthRepository monthRepository, ArticleAndWebRepository articleAndWebRepository) {
        this.articleRepository = articleRepository;
        this.webRepository = webRepository;
        this.monthRepository = monthRepository;
        this.articleAndWebRepository = articleAndWebRepository;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ArticleDto queryById(Integer id) {
        return articleRepository.findArticleById(id);
    }
    @Override
    public List<ArticleDto> queryByBody(String body){
        return articleRepository.findArticlesByBody(body);
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
    public void insert(ArticleDto articleDto) {
        articleRepository.save(articleDto);
    }
    /**
     * 修改数据
     *
     * @param articleDto 实例对象
     */
    @Override
    public void update(ArticleDto articleDto) {
        var reArticle = articleRepository.findArticleById(articleDto.getId());
        BeanUtils.copyProperties(articleDto, reArticle);
        articleRepository.save(reArticle);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     */
    @Override
    public void deleteById(Integer id) {
        articleRepository.deleteById(id);
    }

    /**
     * 返回新闻社分别统计的文章的总数
     *
     * @return 新闻社文章数量
     */
    @Override
    public List<WebArticleCountVo> queryWebArticleSum() {
        List<WebArticleCountVo> webCount = new ArrayList<>();
        webRepository.findAll().forEach(w -> {
            var web = new WebArticleCountVo();
            web.setWebName(w.getWebName());
            web.setArticleCount(articleRepository.findArticleByWebsiteId(w.getWebsiteId()).size());
            webCount.add(web);
        });
        return webCount;
    }

    /**
     * 新闻事件统计的预处理
     */
    @Override
    public void articleAndWebUpdate() {
        webRepository.findAll().forEach(w -> {
            var aw = new ArticleAndWebDto();
            aw.setWebName(w.getWebName());
            articleRepository.findArticleByWebsiteId(w.getWebsiteId()).forEach(a -> {
                if(monthRepository.existsMontharticleDtoByMaId(a.getId())) {
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
    public List<WebArticleSenCountVo> queryWebSenSum(Integer sentiment) {
        List<WebArticleSenCountVo> webSenCount = new ArrayList<>();
        articleAndWebRepository.findAll().stream()
                .filter(aw -> aw.getSentiment().equals(sentiment));
//                .collect(Collectors.summingInt(ArticleAndWebDto::getWebName));
        return webSenCount;
    }
}
