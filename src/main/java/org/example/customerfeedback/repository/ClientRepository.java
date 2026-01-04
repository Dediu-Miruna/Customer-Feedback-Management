package org.example.customerfeedback.repository;

import org.example.customerfeedback.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

