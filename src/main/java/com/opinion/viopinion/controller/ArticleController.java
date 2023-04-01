package com.opinion.viopinion.controller;

import com.opinion.viopinion.entity.dto.ArticleDto;
import com.opinion.viopinion.entity.vo.WebArticleCountVo;
import com.opinion.viopinion.service.impl.ArticleServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (Article)表控制层
 * @author makejava
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
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ArticleDto> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(articleServiceImpl.queryById(id));
    }

    @GetMapping("/body/{body}")
    public ResponseEntity<List<ArticleDto>> queryByBody(@PathVariable("body") String body){
        return ResponseEntity.ok(articleServiceImpl.queryByBody(body));
    }

    /**
     * 分页查询
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ArticleDto>> queryByPage(PageRequest pageRequest) {
        return ResponseEntity.ok(articleServiceImpl.queryByPage(pageRequest));
    }

    /**
     * 新增数据
     *
     * @param articleDto 实体
     */
    @PostMapping
    public void add(ArticleDto articleDto) {
        articleServiceImpl.insert(articleDto);
    }

    /**
     * 编辑数据
     *
     * @param articleDto 实体
     */
    @PutMapping
    public void edit(ArticleDto articleDto) {
        articleServiceImpl.update(articleDto);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     */
    @DeleteMapping
    public void deleteById(Integer id) {
        articleServiceImpl.deleteById(id);
    }

    /**
     * 返回新闻社分别统计的文章的总数
     */
    @GetMapping("/webSum")
    public ResponseEntity<List<WebArticleCountVo>> queryWebArticleSum(){
        return ResponseEntity.ok(articleServiceImpl.queryWebArticleSum());
    }
}


