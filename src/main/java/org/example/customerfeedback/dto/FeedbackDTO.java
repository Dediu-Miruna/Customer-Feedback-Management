package org.example.customerfeedback.dto;

import org.example.customerfeedback.enums.FeedbackType;

import java.time.LocalDateTime;

public class FeedbackDTO {

    private Long feedbackId;
    private String titlu;
    private String descriere;
    private String source;
    private LocalDateTime createdAt;
    private FeedbackType tip;
    private Integer sentimentScore;

    private Long clientId;
    private Long produsId;
    private Long categorieId;

    public FeedbackDTO() {}

    public FeedbackDTO(Long feedbackId, String titlu, String descriere, String source,
                       LocalDateTime createdAt, FeedbackType tip, Integer sentimentScore,
                       Long clientId, Long produsId, Long categorieId) {
        this.feedbackId = feedbackId;
        this.titlu = titlu;
        this.descriere = descriere;
        this.source = source;
        this.createdAt = createdAt;
        this.tip = tip;
        this.sentimentScore = sentimentScore;
        this.clientId = clientId;
        this.produsId = produsId;
        this.categorieId = categorieId;
    }

    public Long getFeedbackId() { return feedbackId; }
    public void setFeedbackId(Long feedbackId) { this.feedbackId = feedbackId; }

    public String getTitlu() { return titlu; }
    public void setTitlu(String titlu) { this.titlu = titlu; }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public FeedbackType getTip() { return tip; }
    public void setTip(FeedbackType tip) { this.tip = tip; }

    public Integer getSentimentScore() { return sentimentScore; }
    public void setSentimentScore(Integer sentimentScore) { this.sentimentScore = sentimentScore; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public Long getProdusId() { return produsId; }
    public void setProdusId(Long produsId) { this.produsId = produsId; }

    public Long getCategorieId() { return categorieId; }
    public void setCategorieId(Long categorieId) { this.categorieId = categorieId; }
}
