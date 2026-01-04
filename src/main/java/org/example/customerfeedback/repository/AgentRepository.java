package org.example.customerfeedback.repository;

import org.example.customerfeedback.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}

