package com.noraai.service;

import com.noraai.model.InterviewScore;
import com.noraai.repository.InterviewScoreRepository;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    @Autowired
    private InterviewScoreRepository scoreRepo;

    public byte[] generateFeedbackPdf(Long scoreId) throws Exception {
        InterviewScore score = scoreRepo.findById(scoreId).orElseThrow();
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream stream = new PDPageContentStream(document, page);
        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        stream.setLeading(18f);
        stream.newLineAtOffset(50, 750);
        stream.showText("Nora AI Interview Feedback Report");
        stream.newLine();
        stream.setFont(PDType1Font.HELVETICA, 12);
        stream.showText("Session ID: " + score.getSessionId());
        stream.newLine();
        stream.showText("Communication: " + score.getCommunication());
        stream.newLine();
        stream.showText("Problem Solving: " + score.getProblemSolving());
        stream.newLine();
        stream.showText("Confidence: " + score.getConfidence());
        stream.newLine();
        stream.showText("Total Score: " + score.getTotalScore());
        stream.endText();
        stream.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();

        return baos.toByteArray();
    }
}