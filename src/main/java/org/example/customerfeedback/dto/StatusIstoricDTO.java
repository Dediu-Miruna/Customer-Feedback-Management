package org.example.customerfeedback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.customerfeedback.enums.TicketStatus;

import java.time.LocalDateTime;

public class StatusIstoricDTO {

    @JsonProperty("id")
    private Long istoricId;

    private TicketStatus vechiulStatus;
    private TicketStatus noulStatus;

    private String modificatDe;
    private LocalDateTime modificatLa;

    public StatusIstoricDTO() {}

    public StatusIstoricDTO(Long id, TicketStatus vechiulStatus, TicketStatus noulStatus,
                            String modificatDe, LocalDateTime modificatLa) {

        this.istoricId = id;
        this.vechiulStatus = vechiulStatus;
        this.noulStatus = noulStatus;
        this.modificatDe = modificatDe;
        this.modificatLa = modificatLa;
    }

    // ---------- GETTERE & SETTERE ----------

    public Long getIstoricId() { return istoricId; }
    public void setIstoricId(Long istoricId) { this.istoricId = istoricId; }

    public TicketStatus getVechiulStatus() { return vechiulStatus; }
    public void setVechiulStatus(TicketStatus vechiulStatus) { this.vechiulStatus = vechiulStatus; }

    public TicketStatus getNoulStatus() { return noulStatus; }
    public void setNoulStatus(TicketStatus noulStatus) { this.noulStatus = noulStatus; }

    public String getModificatDe() { return modificatDe; }
    public void setModificatDe(String modificatDe) { this.modificatDe = modificatDe; }

    public LocalDateTime getModificatLa() { return modificatLa; }
    public void setModificatLa(LocalDateTime modificatLa) { this.modificatLa = modificatLa; }
}
