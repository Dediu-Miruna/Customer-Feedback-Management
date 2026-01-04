package org.example.customerfeedback.domain;

import jakarta.persistence.*;

@Entity
public class RezultatAnalizaSentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rezultatId;

    private Integer scorSentiment;     // 0-100
    private String emotieDominanta;    // ex: "pozitiv", "negativ", "neutru"
    private String topics;             // listă de topicuri într-un singur text

    // Relatie cu Feedback
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    public RezultatAnalizaSentiment() {}

    public RezultatAnalizaSentiment(Integer scorSentiment, String emotieDominanta, String topics) {
        this.scorSentiment = scorSentiment;
        this.emotieDominanta = emotieDominanta;
        this.topics = topics;
    }

    // GETTERE & SETTERE

    public Long getRezultatId() { return rezultatId; }

    public Integer getScorSentiment() { return scorSentiment; }
    public void setScorSentiment(Integer scorSentiment) { this.scorSentiment = scorSentiment; }

    public String getEmotieDominanta() { return emotieDominanta; }
    public void setEmotieDominanta(String emotieDominanta) { this.emotieDominanta = emotieDominanta; }

    public String getTopics() { return topics; }
    public void setTopics(String topics) { this.topics = topics; }

    public Feedback getFeedback() { return feedback; }
    public void setFeedback(Feedback feedback) { this.feedback = feedback; }
}

