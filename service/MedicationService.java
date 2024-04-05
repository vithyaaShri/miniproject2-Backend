package com.miniproject2.miniproject2.service;

import com.miniproject2.miniproject2.dto.DoctorDto;
import com.miniproject2.miniproject2.dto.MedicationDto;

import java.util.List;

public interface MedicationService {
   MedicationDto addMedication(MedicationDto medicationDto);

    MedicationDto getMedicationById(Long id);

    List<MedicationDto> getAllMedication();

    MedicationDto updateMedication(MedicationDto medicationDto, Long id);
    void deleteMedication(Long id);
}
