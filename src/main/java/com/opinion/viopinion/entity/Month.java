package com.opinion.viopinion.entity;

import java.util.Date;

public class Month {

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
     * 文章摘要
     */
    private String abstract1;

    /**
     * 文章内容
     */
    private String body;

    /**
     * body中的图片链接,多个图片分号隔开，pic/img1.jpg;pic/img2.jps
     */
    private String images;


    /**
     * 热点事件部分
     */

    /**
     * 热点事件id，对应event表的id
     */
    private Integer month_event;


    /**
     * 文章id，对应article表的id
     */
    private Integer m_id;

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

    public String getAbstract1() {
        return abstract1;
    }

    public void setAbstract1(String abstract1) {
        this.abstract1 = abstract1;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getMonth_event() {
        return month_event;
    }

    public void setMonth_event(Integer month_event) {
        this.month_event = month_event;
    }

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }
}
