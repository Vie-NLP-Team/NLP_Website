package com.opinion.viopinion.service.impl;

import com.opinion.viopinion.entity.Article;
import com.opinion.viopinion.entity.Month;
import com.opinion.viopinion.entity.Web;
import com.opinion.viopinion.dao.ArticleDao;
import com.opinion.viopinion.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Article)表服务实现类
 *
 * @author makejava
 * @since 2022-03-06 11:52:32
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Article queryById(Integer id) {
        return this.articleDao.queryById(id);
    }
    @Override
    public List<Article> queryByBody(String body){return articleDao.queryByBody(body);}

    /**
     * 分页查询
     *
     * @param article 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Article> queryByPage(Article article, PageRequest pageRequest) {
        long total = this.articleDao.count(article);
        return new PageImpl<>(this.articleDao.queryAllByLimit(article, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public Article insert(Article article) {
        this.articleDao.insert(article);
        return article;
    }

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 实例对象
     */
    @Override
    public Article update(Article article) {
        this.articleDao.update(article);
        return this.queryById(article.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.articleDao.deleteById(id) > 0;
    }


    /**
     * 返回新闻社分别统计的文章的总数
     * @param
     * @return
     */
    @Override
    public List<Web> queryWebArticleSum() {
        return this.articleDao.queryWebArticleSum();
    }

    /**
     * 返回根据新闻社类别统计的文章的正面或负面总数
     */
    @Override
    public List<Web> queryWebSenSum(Integer sentiment) {
        return this.articleDao.queryWebSenSum(sentiment);
    }

    /**
     * 统计每个事件的各个新闻社的新闻数量
     */
    @Override
    public List<Web> queryWebSenEventSum(Integer monthevent, Integer sentiment) {
        return this.articleDao.queryWebSenEventSum(monthevent, sentiment);
    }
}
