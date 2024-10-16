package com.projects.thebestpiwobackend.piwa;

import com.projects.thebestpiwobackend.piwa.dtos.QuestionResponse;
import com.projects.thebestpiwobackend.piwa.repository.PiwoRepository;
import com.projects.thebestpiwobackend.piwa.repository.QuestionRepository;
import com.projects.thebestpiwobackend.piwa.repository.entities.PiwoEntity;
import com.projects.thebestpiwobackend.piwa.repository.entities.QuestionEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
class PiwoRaterService {
    private final RandomIdPairGenerator randomIdPairGenerator;
    private final QuestionRepository questionRepository;
    private final PiwoRepository piwoRepository;
    private final EloRatingCalculator eloRatingCalculator = new EloRatingCalculator();

    public PiwoRaterService(RandomIdPairGenerator randomIdPairGenerator, QuestionRepository questionRepository, PiwoRepository piwoRepository) {
        this.randomIdPairGenerator = randomIdPairGenerator;
        this.questionRepository = questionRepository;
        this.piwoRepository = piwoRepository;
    }

    public QuestionResponse generateQuestion() {
        UUID uuid = UUID.randomUUID();
        PiwoIdPair pair = randomIdPairGenerator.generate();

        questionRepository.insert(new QuestionEntity(uuid, pair.id(), pair.id2(), LocalDateTime.now()));
        return new QuestionResponse(uuid.toString(), pair.id(), pair.id2());

    }

    public void processAnswer(UUID id, int winnerPiwoId) {
        //check if the question with this id exists
        Optional<QuestionEntity> optionalQuestion = questionRepository.getById(id);
        if(optionalQuestion.isEmpty()) {
            throw new RuntimeException("Question not found");
        }
        QuestionEntity question = optionalQuestion.get();

        //check if the winnerId is one of the two in the question
        if(question.getFirstPiwoId() != winnerPiwoId && question.getSecondPiwoId() != winnerPiwoId) {
            throw new RuntimeException("This piwo isn't in the question");
        }

        //update the rating of both objects
        Optional<PiwoEntity> first = piwoRepository.getById(question.getFirstPiwoId());
        Optional<PiwoEntity> second = piwoRepository.getById(question.getSecondPiwoId());
        if(first.isEmpty() || second.isEmpty()){
            throw new RuntimeException("One of the ids were invalid: " + question.getFirstPiwoId() + "or" + question.getSecondPiwoId());
        }

        PiwoEntity firstPiwo = first.get();
        PiwoEntity secondPiwo = second.get();

        RatingPair ratingPair;
        if(winnerPiwoId == question.getFirstPiwoId()){
             ratingPair = eloRatingCalculator.calculateNewRatings(firstPiwo.getRating(), secondPiwo.getRating());
             firstPiwo.setRating(ratingPair.winnerRating());
             secondPiwo.setRating(ratingPair.loserRating());
        }
        else {
            ratingPair = eloRatingCalculator.calculateNewRatings(secondPiwo.getRating(), firstPiwo.getRating());
            secondPiwo.setRating(ratingPair.winnerRating());
            firstPiwo.setRating(ratingPair.loserRating());
        }
        //Tutaj tak naprawdę powinno się użyć transactional

        //delete the question from the database
        questionRepository.delete(id);
    }

    public List<PiwoEntity> getLeaderboad() {
        return piwoRepository.getAllSortedByRating();
    }
}
