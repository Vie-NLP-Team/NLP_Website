package com.opinion.viopinion.service;

import com.opinion.viopinion.entity.Article;
import com.opinion.viopinion.entity.Month;
import com.opinion.viopinion.entity.Web;
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
    Article queryById(Integer id);
    List<Article> queryByBody(String body);

    /**
     * 分页查询
     *
     * @param article 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Article> queryByPage(Article article, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    Article update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 返回新闻社分别统计的文章的总数
     * @param
     * @return
     */
    List<Web> queryWebArticleSum();

    /**
     * 返回根据新闻社类别统计的文章的正面或负面总数
     */
    List<Web> queryWebSenSum(Integer sentiment);

    /**
     * 统计每个事件的各个新闻社的新闻数量
     */
    List<Web> queryWebSenEventSum(Integer monthevent, Integer sentiment);
}
