package org.example.customerfeedback.repository;

import org.example.customerfeedback.domain.SLA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SLARepository extends JpaRepository<SLA, Long> {
}

