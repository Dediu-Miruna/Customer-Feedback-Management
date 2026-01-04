package org.example.customerfeedback.controllers;

import org.example.customerfeedback.dto.FeedbackDTO;
import org.example.customerfeedback.enums.FeedbackType;
import org.example.customerfeedback.services.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/{clientId}/{produsId}/{categorieId}")
    public FeedbackDTO adaugaFeedback(
            @PathVariable Long clientId,
            @PathVariable Long produsId,
            @PathVariable Long categorieId,
            @RequestParam String titlu,
            @RequestParam String descriere,
            @RequestParam(required = false) String source,
            @RequestParam FeedbackType tip
    ) {
        return feedbackService.adaugaFeedback(
                clientId, produsId, categorieId, titlu, descriere, source, tip
        );
    }

    @GetMapping("/{id}")
    public FeedbackDTO getFeedback(@PathVariable Long id) {
        return feedbackService.getFeedback(id);
    }

    @GetMapping
    public List<FeedbackDTO> getToate() {
        return feedbackService.getToateFeedback();
    }

    @DeleteMapping("/{id}")
    public void stergeFeedback(@PathVariable Long id) {
        feedbackService.stergeFeedback(id);
    }
}
