package com.noraai.controller;

import com.noraai.model.InterviewScore;
import com.noraai.service.ScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scoring")
public class ScoringController {

    @Autowired
    private ScoringService service;

    @PostMapping("/generate")
    public InterviewScore generate(@RequestParam Long sessionId) {
        return service.generateScore(sessionId);
    }
}