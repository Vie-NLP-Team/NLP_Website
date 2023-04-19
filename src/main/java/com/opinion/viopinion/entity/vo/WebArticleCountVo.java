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

    public WebArticleCountVo(String webName, Integer articleCount) {
        this.webName = webName;
        this.articleCount = articleCount;
    }
}
