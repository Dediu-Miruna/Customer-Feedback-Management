package org.example.customerfeedback.repository;

import org.example.customerfeedback.domain.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdusRepository extends JpaRepository<Produs, Long> {
}

