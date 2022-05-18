package com.opinion.viopinion.entity;

public class Web {
    /**
     * 新闻社
     */
    private String web_name;

    /**
     * 统计每个新闻社的文章总数
     */
    private Integer article_count;

    /**
     *统计每个新闻社的正面或负面文章总数
     */
    private Integer sentiment_count;

    /**
     *输入需要查询的正面或负面文章总数，1代表正面，0代表负面
     */
    private Integer sentiment;

    /**
     * 热点事件id，对应event表的id
     */
    private Integer monthevent;

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

    public Integer getSentiment_count() {
        return sentiment_count;
    }

    public void setSentiment_count(Integer sentiment_count) {
        this.sentiment_count = sentiment_count;
    }

    public Integer getSentiment() {
        return sentiment;
    }

    public void setSentiment(Integer sentiment) {
        this.sentiment = sentiment;
    }

    public Integer getMonthevent() {
        return monthevent;
    }

    public void setMonthevent(Integer monthevent) {
        this.monthevent = monthevent;
    }
}
