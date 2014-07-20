package com.brownbag.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * User: Juan
 * Date: 7/19/2014
 */
@MappedSuperclass
public abstract class AbstractSentimentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private Integer tone;
    private Integer significance;
    private Integer power;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTone() {
        return tone;
    }

    public void setTone(Integer tone) {
        this.tone = tone;
    }

    public Integer getSignificance() {
        return significance;
    }

    public void setSignificance(Integer significance) {
        this.significance = significance;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
