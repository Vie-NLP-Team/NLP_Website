package com.opinion.viopinion.service;

import com.opinion.viopinion.entity.dto.ArticleDto;
import com.opinion.viopinion.entity.vo.WebArticleCountVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * (Article)表服务接口
 *
 * @author makejava
 * @since 2022-03-06 11:52:31
 */
public interface ArticleService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ArticleDto queryById(Integer id);
    /**
     * 通过Body查询单条数据
     *
     * @param body 输入
     * @return Article
     */
    List<ArticleDto> queryByBody(String body);
    /**
     * 分页查询
     *
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ArticleDto> queryByPage(PageRequest pageRequest);
    /**
     * 新增数据
     *
     * @param articleDto 实例对象
     */
    void insert(ArticleDto articleDto);

    /**
     * 修改数据
     *
     * @param articleDto 实例对象
     */
    void update(ArticleDto articleDto);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     */
    void deleteById(Integer id);

    /**
     * 返回新闻社分别统计的文章的总数
     *
     * @return WebArticleCountVo
     */
    List<WebArticleCountVo> queryWebArticleSum();
}
