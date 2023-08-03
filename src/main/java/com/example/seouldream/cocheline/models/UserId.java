package com.example.seouldream.cocheline.models;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class UserId implements Serializable {
    @Column(name = "id")
    private String value;

    private UserId() {
    }

    public UserId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
