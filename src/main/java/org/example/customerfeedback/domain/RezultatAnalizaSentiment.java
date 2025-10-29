package org.example.customerfeedback.domain;

import java.util.List;

public class RezultatAnalizaSentiment {

    private double scorSentiment;  // între -1 și 1
    private String emotieDominanta;
    private List<String> subiecte;
    private double incredere;

    // Getteri și setteri
    public double getScorSentiment() { return scorSentiment; }
    public void setScorSentiment(double scorSentiment) { this.scorSentiment = scorSentiment; }

    public String getEmotieDominanta() { return emotieDominanta; }
    public void setEmotieDominanta(String emotieDominanta) { this.emotieDominanta = emotieDominanta; }

    public List<String> getSubiecte() { return subiecte; }
    public void setSubiecte(List<String> subiecte) { this.subiecte = subiecte; }

    public double getIncredere() { return incredere; }
    public void setIncredere(double incredere) { this.incredere = incredere; }
}

