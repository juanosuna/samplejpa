package com.brownbag.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * User: Juan
 * Date: 7/19/2014
 */
@Entity
public class Tag extends AbstractSentimentEntity {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Article article;

    private int topic;

    protected Tag() {
    }

    public Tag(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }
}
