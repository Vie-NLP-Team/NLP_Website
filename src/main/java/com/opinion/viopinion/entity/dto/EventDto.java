package com.opinion.viopinion.entity.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "event")
public class EventDto {
    /**
     * ID
     */
    @Id
    private Integer eventId;
    /**
     * 事件图片url
     */
    private String eventImage;
    private String title;
    private String keyword;
    private String abstract2;
    /**
     * 正面情感
     */
    private Integer sentimentPos;
    /**
     * 负面情感
     */
    private Integer sentimentNeg;
    /**
     * 中立态度
     */
    private Integer sentimentMiddle;
    /**
     * 总数统计
     */
    private Integer countEvent;
    /**
     * 热点事件周期
     */
    private Integer newsCycle;
}
