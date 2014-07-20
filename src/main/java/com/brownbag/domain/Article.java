package com.brownbag.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Juan
 * Date: 7/19/2014
 */
@Entity
public class Article extends AbstractSentimentEntity {

    private static final long serialVersionUID = 1L;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "article", cascade = CascadeType.ALL)
    private Set<Tag> tags = new HashSet<Tag>();

    public Article() {
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Tag createTag() {
        Tag tag = new Tag(this);
        tags.add(tag);

        return tag;
    }
}
