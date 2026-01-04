package org.example.customerfeedback;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestApiTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreareAgent() {
        String url = "/agenti?nume=Ion%20Popescu&email=ion@test.com&activ=true";

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);

        assert(response.getStatusCode() == HttpStatus.OK);
        assert(response.getBody().contains("Ion"));
    }

    @Test
    void testCreareFeedback() {
        // Ai nevoie de clientId=1, produsId=1, categorieId=1 în DB!
        String url = "/feedback/1/1/1?titlu=Test&descriere=MergeBine&tip=BUG";

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);

        assert(response.getStatusCode() == HttpStatus.OK);
        assert(response.getBody().contains("Test"));
    }

    @Test
    void testTicketWorkflow() {

        // 1. Creează tichet nou
        String createUrl = "/tickets/1?prioritate=MEDIE";
        ResponseEntity<String> r1 = restTemplate.postForEntity(createUrl, null, String.class);
        assert(r1.getStatusCode() == HttpStatus.OK);

        // Extragem ticketId (metodă simplă)
        String body = r1.getBody();
        String numberOnly = body.replaceAll("\\D+", "");
        Long ticketId = Long.parseLong(numberOnly);

        // 2. Atribuie agent
        String atribuireUrl = "/tickets/" + ticketId + "/atribuie/1";
        ResponseEntity<String> r2 = restTemplate.exchange(atribuireUrl, HttpMethod.PUT, null, String.class);
        assert(r2.getStatusCode() == HttpStatus.OK);
        assert(r2.getBody().contains("IN_LUCRU"));

        // 3. Închide tichet
        String inchideUrl = "/tickets/" + ticketId + "/inchis";
        ResponseEntity<String> r3 = restTemplate.exchange(inchideUrl, HttpMethod.PUT, null, String.class);
        assert(r3.getStatusCode() == HttpStatus.OK);
        assert(r3.getBody().contains("INCHIS"));
    }
}
