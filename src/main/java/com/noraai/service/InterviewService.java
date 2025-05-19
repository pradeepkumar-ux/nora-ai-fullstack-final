package com.noraai.service;

import com.noraai.model.InterviewSession;
import com.noraai.repository.InterviewSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewSessionRepository sessionRepo;

    public InterviewSession startSession(Long resumeId, Long jdId) {
        InterviewSession session = new InterviewSession();
        session.setResumeId(resumeId);
        session.setJdId(jdId);
        session.setCurrentQuestion("Tell me about yourself.");
        session.setStartedAt(LocalDateTime.now());
        session.setQuestionCount(0);
        session.setActive(true);
        return sessionRepo.save(session);
    }

    public InterviewSession answerQuestion(Long sessionId, String answer) {
        InterviewSession session = sessionRepo.findById(sessionId).orElseThrow();
        session.setLastAnswer(answer);
        session.setQuestionCount(session.getQuestionCount() + 1);
        // Simulate adaptive question logic
        session.setCurrentQuestion("What makes you a good fit for this role?");
        if (session.getQuestionCount() >= 5) {
            session.setEndedAt(LocalDateTime.now());
            session.setActive(false);
        }
        return sessionRepo.save(session);
    }

    public List<InterviewSession> getAllSessions() {
        return sessionRepo.findAll();
    }
}