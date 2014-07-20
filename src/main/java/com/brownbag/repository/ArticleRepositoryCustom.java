package com.brownbag.repository;

import com.brownbag.domain.Article;
import com.brownbag.domain.filter.ArticleFilter;

import java.util.List;

/**
 * User: Juan
 * Date: 7/19/2014
 */
public interface ArticleRepositoryCustom {
    List<Article> findByFilter(ArticleFilter articleFilter);
}
