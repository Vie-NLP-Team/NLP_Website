package com.opinion.viopinion.service.impl;

import com.opinion.viopinion.entity.dto.ArticleDto;
import com.opinion.viopinion.entity.vo.WebArticleCountVo;
import com.opinion.viopinion.repository.ArticleRepository;
import com.opinion.viopinion.repository.WebRepository;
import com.opinion.viopinion.service.ArticleService;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * (Article)表服务实现类
 * @author makejava
 * @since 2022-03-06 11:52:32
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final WebRepository webRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, WebRepository webRepository) {
        this.articleRepository = articleRepository;
        this.webRepository = webRepository;
    }

    /**
     * 通过ID查询单条数据
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
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ArticleDto> queryByPage(PageRequest pageRequest) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = Sort.by(order);
        Pageable pageable = PageRequest.of(1,2,sort);
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
     * @return Web
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
}
