package com.miniproject2.miniproject2.repository;

import com.miniproject2.miniproject2.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication,Long> {
}
