package com.projects.thebestpiwobackend.piwa.repository;

import com.projects.thebestpiwobackend.piwa.repository.entities.PiwoEntity;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PiwoRepository {
    private final Map<Integer, PiwoEntity> db = new ConcurrentHashMap<>();

    public Optional<PiwoEntity> getById(int id) {
        return Optional.ofNullable(db.get(id));
    }

    public List<PiwoEntity> getAllSortedByRating() {
        return db.values().stream()
                .sorted((p1,p2) -> p2.getRating() - p1.getRating())
                .toList();
    }
}
