package com.noraai.controller;

import com.noraai.model.Resume;
import com.noraai.model.JobDescription;
import com.noraai.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    @Autowired
    private InterviewService service;

    @PostMapping("/upload-resume")
    public Resume uploadResume(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String phone,
                                @RequestParam String skills,
                                @RequestParam String text) {
        return service.saveResume(name, email, phone, skills, text);
    }

    @PostMapping("/upload-jd")
    public JobDescription uploadJD(@RequestParam String position,
                                   @RequestParam String skills,
                                   @RequestParam String text) {
        return service.saveJD(position, skills, text);
    }
}