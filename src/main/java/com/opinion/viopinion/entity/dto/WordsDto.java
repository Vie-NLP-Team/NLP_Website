package com.opinion.viopinion.entity.dto;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "words")
public class WordsDto {
    @Id
    private Integer id;
    /**
     * 词语(越南语)
     */
    private String viWord;
    /**
     * 词语(中文)
     */
    private String cnWord;
    /**
     * 词性
     */
    private String nature;
}
