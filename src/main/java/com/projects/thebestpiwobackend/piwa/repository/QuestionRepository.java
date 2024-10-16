package com.projects.thebestpiwobackend.piwa.repository;

import com.projects.thebestpiwobackend.piwa.repository.entities.QuestionEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class QuestionRepository {

    private final Map<UUID, QuestionEntity> db = new ConcurrentHashMap<>();

    public void insert(QuestionEntity questionEntity) {
        db.put(questionEntity.getId(), questionEntity);
    }

    public boolean exists(UUID id) {
        return db.containsKey(id);
    }


    public Optional<QuestionEntity> getById(UUID id) {
        return Optional.ofNullable(db.get(id));
    }

    public void delete(UUID id) {
        db.remove(id);
    }
}
