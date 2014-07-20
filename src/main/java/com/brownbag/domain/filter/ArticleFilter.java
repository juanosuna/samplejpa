/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.brownbag.domain.filter;

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
public class ArticleFilter extends AbstractSentimentFilter {

    private static final long serialVersionUID = 1L;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "articleFilter", cascade = CascadeType.ALL)
    private Set<TagFilter> groups = new HashSet<TagFilter>();

    protected ArticleFilter() {
    }

    public ArticleFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TagFilter> getGroups() {
        return groups;
    }

    public void setGroups(Set<TagFilter> groups) {
        this.groups = groups;
        for (TagFilter group : groups) {
            group.setArticleFilter(this);
        }
    }

    public TagFilter createTagFilter() {
        TagFilter tagFilter = new TagFilter(this);
        groups.add(tagFilter);

        return tagFilter;
    }
}
