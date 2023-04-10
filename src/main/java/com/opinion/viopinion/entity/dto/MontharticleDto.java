package com.opinion.viopinion.entity.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "montharticle")
public class MontharticleDto {
    /**
     * 文章id，对应article表的id
     */
    @Id
    private Integer maId;
    /**
     * 热点事件id，对应event表的id
     */
    private Integer monthevent;
    /**
     * 态度判断依据
     */
    private Integer sentiment;
}
