package org.example.customerfeedback.services;

import org.example.customerfeedback.domain.Client;
import org.example.customerfeedback.domain.Feedback;

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

