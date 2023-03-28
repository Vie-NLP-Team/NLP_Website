package com.opinion.viopinion.service.impl;

import com.opinion.viopinion.entity.vo.MonthVo;
import com.opinion.viopinion.repository.ArticleRepository;
import com.opinion.viopinion.repository.MonthRepository;
import com.opinion.viopinion.service.MonthService;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonthServiceImpl implements MonthService {

    private final MonthRepository monthRepository;
    private final ArticleRepository articleRepository;

    public MonthServiceImpl(MonthRepository monthRepository, ArticleRepository articleRepository) {
        this.monthRepository = monthRepository;
        this.articleRepository = articleRepository;
    }

    /**
     * 通过热点事件id返回新闻列表(再加上摘要文章内容和url)
     *
     * @param monthevent monthevent
     * @return Month
     */
    @Override
    public List<MonthVo> queryMonthOfArticle(Integer monthevent) {
        List<MonthVo> months = new ArrayList<>();
        monthRepository.findMontharticleByMonthevent(monthevent).forEach(m -> {
            MonthVo month = new MonthVo();
            var article = articleRepository.findArticleById(m.getMId());
            BeanUtils.copyProperties(article, month);
            month.setMId(m.getMId());
            month.setMonthevent(m.getMonthevent());
            months.add(month);
        });
        return months;
    }
}
