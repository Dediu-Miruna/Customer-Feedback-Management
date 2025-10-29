package org.example.customerfeedback.domain;

import java.time.LocalDateTime;

public class Raport {

    private Long reportId;
    private String tip;
    private String parametri;
    private LocalDateTime generatLa = LocalDateTime.now();
    private String generatDe;
    private String locatieFisier;

    // Getteri și setteri
    public Long getReportId() { return reportId; }
    public void setReportId(Long reportId) { this.reportId = reportId; }

    public String getTip() { return tip; }
    public void setTip(String tip) { this.tip = tip; }

    public String getParametri() { return parametri; }
    public void setParametri(String parametri) { this.parametri = parametri; }

    public LocalDateTime getGeneratLa() { return generatLa; }
    public void setGeneratLa(LocalDateTime generatLa) { this.generatLa = generatLa; }

    public String getGeneratDe() { return generatDe; }
    public void setGeneratDe(String generatDe) { this.generatDe = generatDe; }

    public String getLocatieFisier() { return locatieFisier; }
    public void setLocatieFisier(String locatieFisier) { this.locatieFisier = locatieFisier; }
}
