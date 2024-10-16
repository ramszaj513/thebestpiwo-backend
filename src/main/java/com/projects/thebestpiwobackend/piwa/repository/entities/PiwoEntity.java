package com.projects.thebestpiwobackend.piwa.repository.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PiwoEntity {
    private int id;
    private String name;
    private int rating;

    public PiwoEntity(String name, int id, int rating) {
        this.name = name;
        this.id = id;
        this.rating = rating;
    }
}
