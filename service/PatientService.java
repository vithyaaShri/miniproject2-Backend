package com.miniproject2.miniproject2.service;

import com.miniproject2.miniproject2.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto addPatient(PatientDto patientDto);

    PatientDto getPatientById(Long id);

    List<PatientDto> getAllPatient();

    PatientDto updatePatient(PatientDto patientDto, Long id);

    void deletePatient(Long id);
    PatientDto findByEmail(String email);
}
