package org.example.customerfeedback.domain;

import java.time.LocalDateTime;

public class Comentariu {

    private Long commentId;
    private Long ticketId;
    private String autor;  // poate fi client sau agent
    private String mesaj;
    private boolean intern;
    private LocalDateTime creatLa = LocalDateTime.now();

    // Getteri și setteri
    public Long getCommentId() { return commentId; }
    public void setCommentId(Long commentId) { this.commentId = commentId; }

    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getMesaj() { return mesaj; }
    public void setMesaj(String mesaj) { this.mesaj = mesaj; }

    public boolean isIntern() { return intern; }
    public void setIntern(boolean intern) { this.intern = intern; }

    public LocalDateTime getCreatLa() { return creatLa; }
    public void setCreatLa(LocalDateTime creatLa) { this.creatLa = creatLa; }
}
