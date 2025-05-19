package com.noraai.model;
import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;
    private String email;
    private String phone;
    private String skills;
    
    @Lob
    private String rawText;

    private LocalDateTime uploadedAt;

    // Getters and Setters
}
