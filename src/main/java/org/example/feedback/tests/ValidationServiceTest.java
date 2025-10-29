package org.example.feedback.tests;

import org.example.feedback.Client;
import org.example.feedback.Feedback;
import org.example.feedback.services.ValidationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationServiceTest {

    @Test
    void testClientValid() {
        Client c = new Client();
        c.setNume("Ana Pop");
        c.setEmail("ana.pop@email.com");

        ValidationService service = new ValidationService();
        assertTrue(service.valideazaClient(c));
    }

    @Test
    void testClientInvalid() {
        Client c = new Client();
        c.setNume("");
        c.setEmail("gresit-email");

        ValidationService service = new ValidationService();
        assertFalse(service.valideazaClient(c));
    }

    @Test
    void testFeedbackValid() {
        Feedback f = new Feedback();
        f.setTitlu("Problema de autentificare");
        f.setDescriere("Aplicația nu permite logarea cu Google.");

        ValidationService service = new ValidationService();
        assertTrue(service.valideazaFeedback(f));
    }

    @Test
    void testFeedbackInvalid() {
        Feedback f = new Feedback();
        f.setTitlu("");
        f.setDescriere("");

        ValidationService service = new ValidationService();
        assertFalse(service.valideazaFeedback(f));
    }
}
