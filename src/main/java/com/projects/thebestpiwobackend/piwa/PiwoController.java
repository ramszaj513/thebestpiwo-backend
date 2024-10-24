package com.projects.thebestpiwobackend.piwa;

import com.projects.thebestpiwobackend.piwa.dtos.AnswerRequestBody;
import com.projects.thebestpiwobackend.piwa.dtos.QuestionResponse;
import com.projects.thebestpiwobackend.piwa.repository.entities.PiwoEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PiwoController {

    private final PiwoRaterService piwoRaterService;

    public PiwoController(PiwoRaterService piwoRaterService) {
        this.piwoRaterService = piwoRaterService;
    }

    @GetMapping("/question")
    public QuestionResponse getQuestion() {
        return piwoRaterService.generateQuestion();
    }

    @PostMapping("/answer")
    public void answer(@RequestBody AnswerRequestBody answerRequestBody) {
        piwoRaterService.processAnswer(answerRequestBody.id(), answerRequestBody.winnerPiwoId());
    }

    @GetMapping("/leaderboard")
    public List<PiwoEntity> getLeaderboad() {
        return piwoRaterService.getLeaderboad();
    }
}
