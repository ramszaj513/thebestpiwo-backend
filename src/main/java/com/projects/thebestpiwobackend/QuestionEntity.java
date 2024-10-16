package com.projects.thebestpiwobackend;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class QuestionEntity {

    private UUID id;
    private int firstPiwoId;
    private int secondPiwoId;
    private LocalDateTime creationTime;

    public QuestionEntity(UUID id, int firstPiwoId, int secondPiwoId, LocalDateTime creationTime) {
        this.id = id;
        this.firstPiwoId = firstPiwoId;
        this.secondPiwoId = secondPiwoId;
        this.creationTime = creationTime;
    }

}
