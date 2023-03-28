package com.opinion.viopinion.service;

import com.opinion.viopinion.entity.vo.MonthVo;
import java.util.List;

public interface MonthService {
    List<MonthVo> queryMonthOfArticle(Integer monthevent);
}
