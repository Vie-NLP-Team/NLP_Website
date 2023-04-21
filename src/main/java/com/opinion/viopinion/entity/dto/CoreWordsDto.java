package com.opinion.viopinion.entity.dto;

import lombok.Data;
import javax.persistence.*;

/**
 * (Core_Words)实体类
 * @since 2024-04-06 11:52:29
 */
@Data
@Entity
@Table(name = "core_words")
public class CoreWordsDto {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 分词
     */
    private String vnWord;
    /**
     * 词性
     */
    private String posTag;
    /**
     * 实体识别
     */
    private String ner;
    /**
     * 分词(中文)
     */
    private String cnWord;
    /**
     * 分词(英文)
     */
    private String enWord;
}
