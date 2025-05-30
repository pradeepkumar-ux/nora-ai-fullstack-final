package com.noraai.model;
import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class InterviewSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long resumeId;
    private Long jdId;

    private String currentQuestion;
    private String lastAnswer;
    private Integer questionCount;
    private boolean active;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    // Getters and Setters
}
