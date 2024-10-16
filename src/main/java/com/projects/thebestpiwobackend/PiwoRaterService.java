package com.projects.thebestpiwobackend;

import ch.qos.logback.core.joran.sanity.Pair;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PiwoRaterService {
    private final RandomIdPairGenerator randomIdPairGenerator;
    private final QuestionRepository questionRepository;

    public PiwoRaterService(RandomIdPairGenerator randomIdPairGenerator, QuestionRepository questionRepository) {
        this.randomIdPairGenerator = randomIdPairGenerator;
        this.questionRepository = questionRepository;
    }

    public QuestionResponse generateQuestion() {
        UUID uuid = UUID.randomUUID();
        PiwoIdPair pair = randomIdPairGenerator.generate();

        questionRepository.insert(new QuestionEntity(uuid, pair.id(), pair.id2(), LocalDateTime.now()));
        return new QuestionResponse(uuid.toString(), pair.id(), pair.id2());

    }
}
