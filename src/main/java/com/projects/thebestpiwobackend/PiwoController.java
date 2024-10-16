package com.projects.thebestpiwobackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
