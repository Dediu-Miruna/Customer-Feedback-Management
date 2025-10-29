package org.example.feedback;

import java.time.LocalDateTime;

public class StatusIstoric {

    private Long historyId;
    private Long ticketId;
    private String statusVechi;
    private String statusNou;
    private String schimbatDe;
    private LocalDateTime schimbatLa = LocalDateTime.now();
    private String motiv;

    // Getteri și setteri
    public Long getHistoryId() { return historyId; }
    public void setHistoryId(Long historyId) { this.historyId = historyId; }

    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }

    public String getStatusVechi() { return statusVechi; }
    public void setStatusVechi(String statusVechi) { this.statusVechi = statusVechi; }

    public String getStatusNou() { return statusNou; }
    public void setStatusNou(String statusNou) { this.statusNou = statusNou; }

    public String getSchimbatDe() { return schimbatDe; }
    public void setSchimbatDe(String schimbatDe) { this.schimbatDe = schimbatDe; }

    public LocalDateTime getSchimbatLa() { return schimbatLa; }
    public void setSchimbatLa(LocalDateTime schimbatLa) { this.schimbatLa = schimbatLa; }

    public String getMotiv() { return motiv; }
    public void setMotiv(String motiv) { this.motiv = motiv; }
}

