package com.brownbag.domain.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * User: Juan
 * Date: 7/19/2014
 */
@Entity
public class TagFilter extends AbstractSentimentFilter {

    private static final long serialVersionUID = 1L;

    private int topic;

    @JsonIgnore
    @ManyToOne(optional = false)
    private ArticleFilter articleFilter;

    protected TagFilter() {
    }

    public TagFilter(ArticleFilter articleFilter) {
        this.articleFilter = articleFilter;
    }


    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }

    public ArticleFilter getArticleFilter() {
        return articleFilter;
    }

    public void setArticleFilter(ArticleFilter articleFilter) {
        this.articleFilter = articleFilter;
    }
}
