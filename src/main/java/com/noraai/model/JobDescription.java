package com.noraai.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JobDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;
    private String requiredSkills;

    @Lob
    private String rawText;

    private LocalDateTime uploadedAt;

    // Getters and Setters
}