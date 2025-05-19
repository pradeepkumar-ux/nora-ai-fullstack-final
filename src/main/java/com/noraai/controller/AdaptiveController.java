package com.noraai.controller;

import com.noraai.model.InterviewSession;
import com.noraai.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adaptive")
public class AdaptiveController {

    @Autowired
    private InterviewService service;

    @PostMapping("/start")
    public InterviewSession start(@RequestParam Long resumeId, @RequestParam Long jdId) {
        return service.startSession(resumeId, jdId);
    }

    @PostMapping("/answer")
    public InterviewSession answer(@RequestParam Long sessionId, @RequestParam String answer) {
        return service.answerQuestion(sessionId, answer);
    }

    @GetMapping("/sessions")
    public List<InterviewSession> allSessions() {
        return service.getAllSessions();
    }
}