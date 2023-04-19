package com.opinion.viopinion.entity.vo;

import lombok.Data;

@Data
public class WebSenVo {
    /**
     * 新闻社 ID
     */
    private Integer websiteId;
    /**
     * 新闻社名称
     */
    private String webName;

    public WebSenVo(Integer websiteId, String webName) {
        this.websiteId = websiteId;
        this.webName = webName;
    }
}
