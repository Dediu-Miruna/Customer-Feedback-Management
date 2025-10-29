package org.example.feedback;

import java.time.LocalDateTime;

public class Atasament {

    private Long attachmentId;
    private String numeFisier;
    private long dimensiune;
    private String tip;
    private String url;
    private String incarcatDe;
    private LocalDateTime incarcatLa = LocalDateTime.now();

    // Getteri și setteri
    public Long getAttachmentId() { return attachmentId; }
    public void setAttachmentId(Long attachmentId) { this.attachmentId = attachmentId; }

    public String getNumeFisier() { return numeFisier; }
    public void setNumeFisier(String numeFisier) { this.numeFisier = numeFisier; }

    public long getDimensiune() { return dimensiune; }
    public void setDimensiune(long dimensiune) { this.dimensiune = dimensiune; }

    public String getTip() { return tip; }
    public void setTip(String tip) { this.tip = tip; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getIncarcatDe() { return incarcatDe; }
    public void setIncarcatDe(String incarcatDe) { this.incarcatDe = incarcatDe; }

    public LocalDateTime getIncarcatLa() { return incarcatLa; }
    public void setIncarcatLa(LocalDateTime incarcatLa) { this.incarcatLa = incarcatLa; }
}
