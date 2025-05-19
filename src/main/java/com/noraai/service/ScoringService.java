package com.noraai.service;

import com.noraai.model.InterviewScore;
import com.noraai.repository.InterviewScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoringService {

    @Autowired
    private InterviewScoreRepository scoreRepo;

    public InterviewScore generateScore(Long sessionId) {
        InterviewScore score = new InterviewScore();
        score.setSessionId(sessionId);
        score.setCommunication((int)(Math.random() * 10 + 1));
        score.setProblemSolving((int)(Math.random() * 10 + 1));
        score.setConfidence((int)(Math.random() * 10 + 1));
        score.setTotalScore(score.getCommunication() + score.getProblemSolving() + score.getConfidence());
        return scoreRepo.save(score);
    }
}