package org.example.customerfeedback.services;

import org.example.customerfeedback.domain.Agent;
import org.example.customerfeedback.domain.Ticket;
import org.example.customerfeedback.enums.TicketStatus;

public class WorkflowService {

    public void atribuieTicket(Ticket ticket, Agent agent) {
        ticket.setAtribuitLui(agent);
        ticket.setStatus(TicketStatus.IN_LUCRU.name());
    }

    public void marcheazaRezolvat(Ticket ticket) {
        ticket.setStatus(TicketStatus.REZOLVAT.name());
    }

    public void inchideTicket(Ticket ticket) {
        ticket.setStatus(TicketStatus.INCHIS.name());
    }
}

