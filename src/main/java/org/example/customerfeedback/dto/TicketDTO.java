package org.example.customerfeedback.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.customerfeedback.enums.Prioritate;
import org.example.customerfeedback.enums.TicketStatus;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDTO {

    @JsonProperty("id")
    private Long ticketId;

    private TicketStatus status;
    private Prioritate prioritate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Relații — expunem doar ID-urile ca să evităm recursivitatea
    private Long agentId;
    private Long feedbackId;

    // Liste DTO
    private List<ComentariuDTO> comentarii;
    private List<StatusIstoricDTO> istorice;

    public TicketDTO() {}

    // ----------- GETTERE & SETTERE ------------

    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }

    public TicketStatus getStatus() { return status; }
    public void setStatus(TicketStatus status) { this.status = status; }

    public Prioritate getPrioritate() { return prioritate; }
    public void setPrioritate(Prioritate prioritate) { this.prioritate = prioritate; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public Long getAgentId() { return agentId; }
    public void setAgentId(Long agentId) { this.agentId = agentId; }

    public Long getFeedbackId() { return feedbackId; }
    public void setFeedbackId(Long feedbackId) { this.feedbackId = feedbackId; }

    public List<ComentariuDTO> getComentarii() { return comentarii; }
    public void setComentarii(List<ComentariuDTO> comentarii) { this.comentarii = comentarii; }

    public List<StatusIstoricDTO> getIstorice() { return istorice; }
    public void setIstorice(List<StatusIstoricDTO> istorice) { this.istorice = istorice; }
}
