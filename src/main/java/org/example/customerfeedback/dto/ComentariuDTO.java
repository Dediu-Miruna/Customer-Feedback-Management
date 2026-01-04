package org.example.customerfeedback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class ComentariuDTO {

    @JsonProperty("id")
    private Long comentariuId;

    private String autor;
    private String text;
    private LocalDateTime createdAt;

    // ------------ Constructori ------------

    public ComentariuDTO() {}

    public ComentariuDTO(Long comentariuId, String autor, String text, LocalDateTime createdAt) {
        this.comentariuId = comentariuId;
        this.autor = autor;
        this.text = text;
        this.createdAt = createdAt;
    }

    // ------------ Gettere & Settere ------------

    public Long getComentariuId() {
        return comentariuId;
    }

    public void setComentariuId(Long comentariuId) {
        this.comentariuId = comentariuId;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

