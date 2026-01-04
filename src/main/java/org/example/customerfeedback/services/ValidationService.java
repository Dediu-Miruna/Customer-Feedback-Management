package org.example.customerfeedback.services;

import org.example.customerfeedback.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    // ----------------------------------------------------
    // VALIDARE FEEDBACK
    // ----------------------------------------------------
    public void valideazaFeedback(Feedback feedback) {

        if (feedback == null) {
            throw new IllegalArgumentException("Feedback-ul este null.");
        }

        if (feedback.getTitlu() == null || feedback.getTitlu().isBlank()) {
            throw new IllegalArgumentException("Titlul feedback-ului nu poate fi gol.");
        }

        if (feedback.getDescriere() == null || feedback.getDescriere().isBlank()) {
            throw new IllegalArgumentException("Descrierea nu poate fi goală.");
        }

        if (feedback.getTip() == null) {
            throw new IllegalArgumentException("Tipul feedback-ului este obligatoriu.");
        }

        if (feedback.getClient() == null) {
            throw new IllegalArgumentException("Feedback-ul trebuie să aibă un client.");
        }

        if (feedback.getCategorie() == null) {
            throw new IllegalArgumentException("Categorie obligatorie.");
        }
    }

    // ----------------------------------------------------
    // VALIDARE CLIENT
    // ----------------------------------------------------
    public void valideazaClient(Client client) {

        if (client == null) {
            throw new IllegalArgumentException("Clientul este null.");
        }

        if (!client.isAnonim()) {
            if (client.getEmail() == null || !client.getEmail().contains("@")) {
                throw new IllegalArgumentException("Email invalid pentru client.");
            }
        }

        if (client.getNume() == null || client.getNume().length() < 2) {
            throw new IllegalArgumentException("Nume client invalid.");
        }
    }

    // ----------------------------------------------------
    // VALIDARE TICKET
    // ----------------------------------------------------
    public void valideazaTicket(Ticket ticket) {

        if (ticket == null) {
            throw new IllegalArgumentException("Ticketul este null.");
        }

        if (ticket.getStatus() == null) {
            throw new IllegalArgumentException("Statusul ticketului nu poate fi null.");
        }

        if (ticket.getPrioritate() == null) {
            throw new IllegalArgumentException("Prioritatea ticketului este obligatorie.");
        }

        if (ticket.getFeedback() == null) {
            throw new IllegalArgumentException("Ticketul trebuie legat de un feedback.");
        }
    }
}

