package com.brownbag.domain.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Juan
 * Date: 7/19/2014
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@MappedSuperclass
public abstract class AbstractSentimentFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private Set<Integer> tones = new HashSet<Integer>();

    @ElementCollection
    private Set<Integer> significances = new HashSet<Integer>();

    @ElementCollection
    private Set<Integer> powers = new HashSet<Integer>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Integer> getTones() {
        return tones;
    }

    public void setTones(Set<Integer> tones) {
        this.tones = tones;
    }

    public void addTones(int... tones) {
        for (int tone : tones) {
            this.tones.add(tone);
        }
    }

    public Set<Integer> getSignificances() {
        return significances;
    }

    public void setSignificances(Set<Integer> significances) {
        this.significances = significances;
    }

    public void addSignificances(int... significances) {
        for (int significance : significances) {
            this.significances.add(significance);
        }
    }

    public Set<Integer> getPowers() {
        return powers;
    }

    public void setPowers(Set<Integer> powers) {
        this.powers = powers;
    }

    public void addPowers(int... powers) {
        for (int power : powers) {
            this.powers.add(power);
        }
    }
}
