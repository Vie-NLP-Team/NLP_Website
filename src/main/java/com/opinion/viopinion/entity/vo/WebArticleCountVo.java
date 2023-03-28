package com.opinion.viopinion.entity.vo;

import lombok.Data;

@Data
public class WebArticleCountVo {
    /**
     * 新闻社
     */
    private String webName;
    /**
     * 统计每个新闻社的文章总数
     */
    private Integer articleCount;
    /**
     * 统计每个新闻社的正面或负面文章总数
     */
    private Integer sentimentCount;
}
