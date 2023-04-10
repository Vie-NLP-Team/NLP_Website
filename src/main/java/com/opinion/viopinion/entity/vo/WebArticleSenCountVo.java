package com.opinion.viopinion.entity.vo;

import lombok.Data;

@Data
public class WebArticleSenCountVo {
    /**
     * 新闻社名称
     */
    private String webName;
    /**
     * 统计新闻社下的正面文章总数
     */
    private Integer sentimentPosCount;
    /**
     * 统计新闻社下的负面文章总数
     */
    private Integer sentimentNegCount;
    /**
     * 统计新闻社下的中立文章总数(结果不明)
     */
    private Integer sentimentMidCount;
}
