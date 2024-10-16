package com.projects.thebestpiwobackend;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class QuestionRepository {

    private final Map<UUID, QuestionEntity> db = new ConcurrentHashMap<>();

    public void insert(QuestionEntity questionEntity) {
        db.put(questionEntity.getId(), questionEntity);
    }
}
