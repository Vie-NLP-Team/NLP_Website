package com.opinion.viopinion.controller;

import com.opinion.viopinion.entity.Article;
import com.opinion.viopinion.entity.Month;
import com.opinion.viopinion.entity.Web;
import com.opinion.viopinion.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2022-03-06 11:52:25
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    /**
     * 分页查询
     *
     * @param article 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Article>> queryByPage(Article article, PageRequest pageRequest) {
        return ResponseEntity.ok(this.articleService.queryByPage(article, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Article> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.articleService.queryById(id));
    }
    @GetMapping("/querybybody/{body}")
    public ResponseEntity<List<Article>> queryByBody(@PathVariable("body") String body){
        return ResponseEntity.ok(articleService.queryByBody(body));
    }
    /**
     * 新增数据
     *
     * @param article 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Article> add(Article article) {
        return ResponseEntity.ok(this.articleService.insert(article));
    }

    /**
     * 编辑数据
     *
     * @param article 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Article> edit(Article article) {
        return ResponseEntity.ok(this.articleService.update(article));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.articleService.deleteById(id));
    }

    /**
     * 返回新闻社分别统计的文章的总数
     */
    @GetMapping("/queryWebArticleSum")
    public ResponseEntity<List<Web>> queryWebArticleSum(){
        return ResponseEntity.ok(this.articleService.queryWebArticleSum());
    }

    /**
     * 返回根据新闻社类别统计的文章的正面或负面总数
     */
    @GetMapping("/queryWebSenSum/{sentiment}")
    public ResponseEntity<List<Web>> queryWebSenSum(@PathVariable("sentiment") Integer sentiment) {
        return ResponseEntity.ok(this.articleService.queryWebSenSum(sentiment));
    }

    /**
     * 统计每个事件的各个新闻社的新闻数量(分正面和负面)
     */
    @GetMapping("/queryWebSenEventSum/{sentiment}/{monthevent}")
    public ResponseEntity<List<Web>> queryWebSenEventSum(@PathVariable("sentiment") Integer sentiment, @PathVariable("monthevent") Integer monthevent) {
        return ResponseEntity.ok(this.articleService.queryWebSenEventSum(sentiment, monthevent));
    }
}


