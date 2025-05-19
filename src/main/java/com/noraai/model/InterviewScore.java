package com.noraai.model;

import jakarta.persistence.*;

@Entity
public class InterviewScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sessionId;
    private int communication;
    private int problemSolving;
    private int confidence;
    private int totalScore;

    // Getters and Setters
}