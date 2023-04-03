package com.opinion.viopinion.entity.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * (Article)实体类
 * @since 2022-03-06 11:52:29
 */
@Data
@Entity
@Table(name = "article")
public class ArticleDto {
    /**
     * 文章编号
     */
    @Id
    private Integer id;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 发布时间
     */
    private Date pubTime;
    /**
     * body中的图片链接,多个图片分号隔开，pic/img1.jpg;pic/img2.jps
     */
    private String images;
    /**
     * 文章摘要
     */
    private String abstract1;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 文章内容
     */
    private String body;
    /**
     * 一级分类
     */
    private String category1;
    /**
     * 二级分类
     */
    private String category2;
    /**
     * 数据库里的网站ID
     */
    private Integer websiteId;
    /**
     * 数据库里的语言项目ID
     */
    private String languageId;
    /**
     * 请求url
     */
    private String requestUrl;
    /**
     * 响应url
     */
    private String responseUrl;
    /**
     * 爬虫时间
     */
    private Date coleTime;
    /**
     * response_url转换为md5
     */
    private String md5;
    /**
     * 源码
     */
    private String html;
}

