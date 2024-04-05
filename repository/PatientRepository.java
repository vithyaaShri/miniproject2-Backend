package com.miniproject2.miniproject2.repository;

import com.miniproject2.miniproject2.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByEmail(String email);
}
