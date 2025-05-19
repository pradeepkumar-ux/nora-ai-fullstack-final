package com.noraai.controller;

import com.noraai.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam Long scoreId) throws Exception {
        byte[] pdf = pdfService.generateFeedbackPdf(scoreId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("feedback.pdf").build());
        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}