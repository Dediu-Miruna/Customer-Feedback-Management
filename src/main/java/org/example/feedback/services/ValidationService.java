package org.example.feedback.services;

import org.example.feedback.Client;
import org.example.feedback.Feedback;

public class ValidationService {

    public boolean valideazaClient(Client client) {
        return client.getEmail() != null && client.getEmail().contains("@") &&
                client.getNume() != null && !client.getNume().isEmpty();
    }

    public boolean valideazaFeedback(Feedback feedback) {
        return feedback.getTitlu() != null && !feedback.getTitlu().isEmpty() &&
                feedback.getDescriere() != null && !feedback.getDescriere().isEmpty();
    }
}

