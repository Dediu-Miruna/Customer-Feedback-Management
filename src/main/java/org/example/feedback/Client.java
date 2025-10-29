package org.example.feedback;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @NotBlank
    private String nume;

    @Email
    private String email;

    private String telefon;
    private boolean anonim;

    @OneToMany(mappedBy = "trimisDe", cascade = CascadeType.ALL)
    private List<Feedback> feedbackuri;

    // Getteri și setteri
    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public boolean isAnonim() { return anonim; }
    public void setAnonim(boolean anonim) { this.anonim = anonim; }

    public List<Feedback> getFeedbackuri() { return feedbackuri; }
    public void setFeedbackuri(List<Feedback> feedbackuri) { this.feedbackuri = feedbackuri; }
}

