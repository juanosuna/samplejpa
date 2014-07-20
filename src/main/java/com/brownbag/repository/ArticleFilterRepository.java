package com.brownbag.repository;

import com.brownbag.domain.filter.ArticleFilter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: Juan
 * Date: 7/19/2014
 */
public interface ArticleFilterRepository extends JpaRepository<ArticleFilter, Long> {
}
