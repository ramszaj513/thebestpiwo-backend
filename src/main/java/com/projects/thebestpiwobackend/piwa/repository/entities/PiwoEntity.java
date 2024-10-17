package com.projects.thebestpiwobackend.piwa.repository.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PiwoEntity {
    private int id;
    private String name;
    private int rating;

    public PiwoEntity(int id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }
}
