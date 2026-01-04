package org.example.customerfeedback.services;

import org.example.customerfeedback.domain.*;
import org.example.customerfeedback.dto.FeedbackDTO;
import org.example.customerfeedback.enums.FeedbackType;
import org.example.customerfeedback.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired private FeedbackRepository feedbackRepository;
    @Autowired private ClientRepository clientRepository;
    @Autowired private ProdusRepository produsRepository;
    @Autowired private CategorieRepository categorieRepository;

    private FeedbackDTO mapToDTO(Feedback feedback) {
        return new FeedbackDTO(
                feedback.getFeedbackId(),
                feedback.getTitlu(),
                feedback.getDescriere(),
                feedback.getSource(),
                feedback.getCreatedAt(),
                feedback.getTip(),
                feedback.getSentimentScore(),
                feedback.getClient() != null ? feedback.getClient().getClientId() : null,
                feedback.getProdus() != null ? feedback.getProdus().getProdusId() : null,
                feedback.getCategorie() != null ? feedback.getCategorie().getCategorieId() : null
        );
    }

    // --------------------- CREATE ----------------------

    public FeedbackDTO adaugaFeedback(Long clientId, Long produsId, Long categorieId,
                                      String titlu, String descriere, String source, FeedbackType tip) {

        Client c = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Clientul nu există!"));

        Produs p = produsRepository.findById(produsId)
                .orElseThrow(() -> new RuntimeException("Produsul nu există!"));

        Categorie cat = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new RuntimeException("Categoria nu există!"));

        Feedback fb = new Feedback(titlu, descriere, tip);
        fb.setClient(c);
        fb.setProdus(p);
        fb.setCategorie(cat);
        fb.setSource(source);

        return mapToDTO(feedbackRepository.save(fb));
    }

    // --------------------- READ ------------------------

    public FeedbackDTO getFeedback(Long id) {
        return feedbackRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Feedback-ul nu există!"));
    }

    public List<FeedbackDTO> getToateFeedback() {
        return feedbackRepository.findAll()
                .stream().map(this::mapToDTO).toList();
    }

    // --------------------- DELETE ----------------------

    public void stergeFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
