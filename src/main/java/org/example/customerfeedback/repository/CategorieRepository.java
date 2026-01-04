package org.example.customerfeedback.repository;

import org.example.customerfeedback.domain.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}

