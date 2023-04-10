package com.opinion.viopinion.entity.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文章和新闻社拼接表
 */
@Data
@Entity
@Table(name = "article_website")
public class ArticleAndWebDto {
    /**
     * 文章 Id
     */
    @Id
    private Integer maId;
    /**
     * 态度数值
     */
    private Integer sentiment;
    /**
     * 新闻社 Id
     */
    private String webName;
    /**
     * 所属聚类事件 Id
     */
    private Integer monthevent;
}
