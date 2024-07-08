package com.example.bbw_stage_4eme_bourawi.job;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface Jobrepository extends CrudRepository<Job_entity, Long> {
    // Ajoutez des méthodes de recherche personnalisées au besoin
}
