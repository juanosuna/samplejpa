package com.brownbag.repository;

import com.brownbag.domain.Article;
import com.brownbag.domain.filter.ArticleFilter;
import com.brownbag.domain.filter.TagFilter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * User: Juan
 * Date: 7/19/2014
 */
public class ArticleRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Article> findByFilter(ArticleFilter articleFilter) {

        StringBuilder builder = new StringBuilder("SELECT DISTINCT a from Article a LEFT JOIN FETCH a.tags t WHERE ");
        List<String> predicates = new ArrayList<String>();
        if (!articleFilter.getTones().isEmpty()) {
            predicates.add("a.tone in :articleTones");
        }
        if (!articleFilter.getPowers().isEmpty()) {
            predicates.add("a.power in :articlePowers");
        }
        if (!articleFilter.getSignificances().isEmpty()) {
            predicates.add("a.significance in :articleSignificances");
        }

        Set<TagFilter> tagFilters = articleFilter.getGroups();
        int i = 0;
        for (TagFilter tagFilter : tagFilters) {
            predicates.add("t.topic is :tag" + i + "Topic");

            if (!tagFilter.getTones().isEmpty()) {
                predicates.add("t.tone in :tag" + i + "Tones");
            }
            if (!tagFilter.getPowers().isEmpty()) {
                predicates.add("t.power in :tag" + i + "Powers");
            }
            if (!tagFilter.getSignificances().isEmpty()) {
                predicates.add("t.significance in :tag" + i + "Significances");
            }
            i++;
        }

        builder.append(StringUtils.join(predicates, " AND "));

        Query query = entityManager.createQuery(builder.toString());
        if (!articleFilter.getTones().isEmpty()) {
            query.setParameter("articleTones", articleFilter.getTones());
        }
        if (!articleFilter.getPowers().isEmpty()) {
            query.setParameter("articlePowers", articleFilter.getPowers());
        }
        if (!articleFilter.getSignificances().isEmpty()) {
            query.setParameter("articleSignificances", articleFilter.getSignificances());
        }

        i = 0;
        for (TagFilter tagFilter : tagFilters) {
            query.setParameter("tag" + i + "Topic", tagFilter.getTopic());

            if (!tagFilter.getTones().isEmpty()) {
                query.setParameter("tag" + i + "Tones", tagFilter.getTones());
            }
            if (!tagFilter.getPowers().isEmpty()) {
                query.setParameter("tag" + i + "Powers", tagFilter.getPowers());
            }
            if (!tagFilter.getSignificances().isEmpty()) {
                query.setParameter("tag" + i + "Significances", tagFilter.getSignificances());
            }
            i++;
        }

        return query.getResultList();
    }
}
