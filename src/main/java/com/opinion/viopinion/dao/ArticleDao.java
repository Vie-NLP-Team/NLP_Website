package com.opinion.viopinion.dao;

import com.opinion.viopinion.entity.Article;
import com.opinion.viopinion.entity.Month;
import com.opinion.viopinion.entity.Web;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Article)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-06 11:52:28
 */
@Mapper
public interface ArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Article queryById(Integer id);
    List<Article> queryByBody(String body);

    /**
     * 查询指定行数据
     *
     * @param article 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Article> queryAllByLimit(Article article, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param article 查询条件
     * @return 总行数
     */
    long count(Article article);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int insert(Article article);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Article> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Article> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Article> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参

    int insertOrUpdateBatch(@Param("entities") List<Article> entities);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
*/
    int deleteById(Integer id);


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

