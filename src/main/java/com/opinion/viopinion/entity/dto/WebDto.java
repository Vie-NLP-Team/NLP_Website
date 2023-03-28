package com.opinion.viopinion.entity.dto;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "website")
public class WebDto {
    /**
     * 新闻社 ID
     */
    @Id
    private Integer websiteId;
    /**
     * 新闻社
     */
    private String webName;
    /**
     * 链接
     */
    private String url;
}
