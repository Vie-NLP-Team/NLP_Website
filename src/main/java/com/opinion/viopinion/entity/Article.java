package com.opinion.viopinion.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2022-03-06 11:52:29
 */
public class Article implements Serializable {
    private static final long serialVersionUID = -31965869851817924L;
    /**
     * 文章编号
     */
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


    /**
     * 新闻社
     */
    private String web_name;

    /**
     * 统计每个新闻社的文章总数
     */
    private Integer article_count;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAbstract1() {
        return abstract1;
    }

    public void setAbstract1(String abstract1) {
        this.abstract1 = abstract1;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    public Date getColeTime() {
        return coleTime;
    }

    public void setColeTime(Date coleTime) {
        this.coleTime = coleTime;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }


    public String getWeb_name() {
        return web_name;
    }

    public void setWeb_name(String web_name) {
        this.web_name = web_name;
    }

    public Integer getArticle_count() {
        return article_count;
    }

    public void setArticle_count(Integer article_count) {
        this.article_count = article_count;
    }
}

