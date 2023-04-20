package com.opinion.viopinion.controller.crud;

import com.opinion.viopinion.entity.dto.ArticleDto;
import com.opinion.viopinion.entity.vo.EventWebSenCountVo;
import com.opinion.viopinion.entity.vo.WebArticleCountVo;
import com.opinion.viopinion.service.impl.ArticleServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (Article)表控制层
 * @since 2022-03-06 11:52:25
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    private final ArticleServiceImpl articleServiceImpl;
    public ArticleController(ArticleServiceImpl articleServiceImpl) {
        this.articleServiceImpl = articleServiceImpl;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ArticleDto> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(articleServiceImpl.queryById(id));
    }

    /**
     * 通过body属性查询单条数据
     *
     * @param body 新闻内容
     * @return 单条数据
     */
    @GetMapping("/body/{body}")
    public ResponseEntity<List<ArticleDto>> queryByBody(@PathVariable("body") String body){
        return ResponseEntity.ok(articleServiceImpl.queryByBody(body));
    }

    /**
     * 分页查询
     *
     * @param pageNum 当前页数
     * @param pageSize 当前页数据量
     * @return 查询结果
     */
    @GetMapping("/{page}/{size}")
    public ResponseEntity<Page<ArticleDto>> queryByPage(@PathVariable("page") Integer pageNum, @PathVariable("size") Integer pageSize) {
        return ResponseEntity.ok(articleServiceImpl.queryByPage(pageNum, pageSize));
    }

    /**
     * 新增数据
     *
     * @param articleDto 实体
     */
    @PostMapping
    public ResponseEntity<String> add(ArticleDto articleDto) {
        return ResponseEntity.ok(articleServiceImpl.insert(articleDto));
    }

    /**
     * 编辑数据
     *
     * @param articleDto 实体
     */
    @PutMapping
    public ResponseEntity<String> edit(ArticleDto articleDto) {
        return ResponseEntity.ok(articleServiceImpl.update(articleDto));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     */
    @DeleteMapping
    public ResponseEntity<String> deleteById(Integer id) {
        return ResponseEntity.ok(articleServiceImpl.deleteById(id));
    }

    /**
     * 返回根据新闻社分别统计的文章的总数
     *
     * @return 新闻社文章数量
     */
    @GetMapping("/webSum")
    public ResponseEntity<List<WebArticleCountVo>> queryWebArticleSum() {
        return ResponseEntity.ok(articleServiceImpl.queryWebArticleSum());
    }

    /**
     * 返回根据新闻社类别统计的文章下的正面态度和负面态度的总数
     *
     * @return 正面统计数量和负面统计数量
     */
    @GetMapping("/webSum/sen/{sentiment}")
    public ResponseEntity<List<WebArticleCountVo>> queryWebSenSum(@PathVariable("sentiment") Integer sentiment) {
        return ResponseEntity.ok(articleServiceImpl.queryWebSenSum(sentiment));
    }

    /**
     * 统计每个事件的各个新闻社的新闻数量(分正面和负面)
     *
     * @return 相关媒体正（负）面新闻数量
     */
    @GetMapping("/queryWebSenEventSum/{monthevent}/{sentiment}")
    public ResponseEntity<List<EventWebSenCountVo>> queryWebSenEventSum(@PathVariable("monthevent") Integer monthevent, @PathVariable("sentiment") Integer sentiment) {
        return ResponseEntity.ok(articleServiceImpl.queryWebSenEventSum(monthevent, sentiment));
    }
}


