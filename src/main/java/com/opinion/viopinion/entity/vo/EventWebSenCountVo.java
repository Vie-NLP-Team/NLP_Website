package com.opinion.viopinion.entity.vo;

import lombok.Data;

@Data
public class EventWebSenCountVo {
    /**
     * 新闻社名称
     */
    private String webName;
    /**
     * 统计文章数
     */
    private Integer articleCount;

    public EventWebSenCountVo(String webName, Integer articleCount) {
        this.webName = webName;
        this.articleCount = articleCount;
    }
}
