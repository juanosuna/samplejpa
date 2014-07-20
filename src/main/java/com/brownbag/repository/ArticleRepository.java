package com.brownbag.repository;

import com.brownbag.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: Juan
 * Date: 7/19/2014
 */
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleRepositoryCustom {
}
