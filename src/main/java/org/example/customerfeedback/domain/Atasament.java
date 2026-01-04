package org.example.customerfeedback.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Atasament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atasamentId;

    private String numeFisier;
    private String tipMime;
    private Long dimensiune;      // în bytes

    private LocalDateTime uploadedAt = LocalDateTime.now();

    // RELATIE CU FEEDBACK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    // Constructori
    public Atasament() {}

    public Atasament(String numeFisier, String tipMime, Long dimensiune) {
        this.numeFisier = numeFisier;
        this.tipMime = tipMime;
        this.dimensiune = dimensiune;
    }

    // GETTERE & SETTERE

    public Long getAtasamentId() { return atasamentId; }

    public String getNumeFisier() { return numeFisier; }
    public void setNumeFisier(String numeFisier) { this.numeFisier = numeFisier; }

    public String getTipMime() { return tipMime; }
    public void setTipMime(String tipMime) { this.tipMime = tipMime; }

    public Long getDimensiune() { return dimensiune; }
    public void setDimensiune(Long dimensiune) { this.dimensiune = dimensiune; }

    public LocalDateTime getUploadedAt() { return uploadedAt; }

    public Feedback getFeedback() { return feedback; }
    public void setFeedback(Feedback feedback) { this.feedback = feedback; }
}

