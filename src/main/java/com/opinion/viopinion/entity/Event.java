package com.opinion.viopinion.entity;

public class Event {

    private Integer event_id;

    private String title;

    private String keyword;

    private String abstract2;

    /**
     * 正面情感
     */

    private Integer sentiment_pos;

    /**
     * 负面情感
     */

    private Integer sentiment_neg;

    /**
     * 中立态度
     */

    private Integer sentiment_middle;

    private Integer count_event;

    /**
     * 热点事件周期
     */
    private Integer news_cycle;

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAbstract2() {return abstract2;}

    public void setAbstract2(String abstract2) {
        this.abstract2 = abstract2;
    }

    public Integer getSentiment_neg() {
        return sentiment_neg;
    }

    public void setSentiment_neg(Integer sentiment_neg) {
        this.sentiment_neg = sentiment_neg;
    }

    public Integer getSentiment_pos() {
        return sentiment_pos;
    }

    public void setSentiment_pos(Integer sentiment_pos) {
        this.sentiment_pos = sentiment_pos;
    }

    public Integer getSentiment_middle() {
        return sentiment_middle;
    }

    public void setSentiment_middle(Integer sentiment_middle) {
        this.sentiment_middle = sentiment_middle;
    }

    public Integer getCount_event() {
        return count_event;
    }

    public void setCount_event(Integer count_event) {
        this.count_event = count_event;
    }

    public Integer getNews_cycle() {
        return news_cycle;
    }

    public void setNews_cycle(Integer news_cycle) {
        this.news_cycle = news_cycle;
    }


}
