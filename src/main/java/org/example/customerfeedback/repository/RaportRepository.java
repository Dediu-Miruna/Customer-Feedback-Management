package org.example.customerfeedback.repository;

import org.example.customerfeedback.domain.Raport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaportRepository extends JpaRepository<Raport, Long> {
}

