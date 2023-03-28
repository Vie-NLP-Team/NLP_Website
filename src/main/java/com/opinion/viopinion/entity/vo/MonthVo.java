package com.opinion.viopinion.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MonthVo {
    /**
     * 热点事件id，对应event表的id
     */
    private Integer monthevent;
    /**
     * 文章id，对应article表的id
     */
    private Integer mId;
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
}
