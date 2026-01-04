package org.example.customerfeedback.repository;

import org.example.customerfeedback.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

