package com.miniproject2.miniproject2.service.Impl;

import com.miniproject2.miniproject2.dto.MedicationDto;
import com.miniproject2.miniproject2.entity.Doctor;
import com.miniproject2.miniproject2.entity.Medication;
import com.miniproject2.miniproject2.repository.DoctorRepository;
import com.miniproject2.miniproject2.repository.MedicationRepository;
import com.miniproject2.miniproject2.service.MedicationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MedicationServiceImpl implements MedicationService {
    private ModelMapper modelMapper;
    private MedicationRepository medicationRepository;
    @Override
    //To Add medication to repository
    public MedicationDto addMedication(MedicationDto medicationDto) {
        Medication medication=modelMapper.map(medicationDto,Medication.class);
        Medication savedMedication=medicationRepository.save(medication);
        return modelMapper.map(savedMedication,MedicationDto.class);
    }
//To get Medicine Based By Id
    @Override
    public MedicationDto getMedicationById(Long id) {
        Medication medication=medicationRepository.findById(id).get();
        return modelMapper.map(medication,MedicationDto.class);
    }
//To get All medicine Detail in List
    @Override
    public List<MedicationDto> getAllMedication() {
        List<Medication> medicationList=medicationRepository.findAll();
        return medicationList.stream().map(list->modelMapper.map(list,MedicationDto.class)).collect(Collectors.toList());
    }
//To Update Medication Based On Id

    @Override
    public MedicationDto updateMedication(MedicationDto medicationDto, Long id) {
        Medication medication=medicationRepository.findById(id).get();
        medication.setMedicineName(medicationDto.getMedicineName());
        medication.setDescription(medicationDto.getDescription());
        medication.setPatientName(medicationDto.getPatientName());
        medication.setAppointmentDate(medicationDto.getAppointmentDate());
        Medication savedmedication=medicationRepository.save(medication);
        return modelMapper.map(savedmedication,MedicationDto.class);
    }
//To Delete Medication Based On Id
    @Override
    public void deleteMedication(Long id) {
       Medication medication=medicationRepository.findById(id).get();
        medicationRepository.delete(medication);

    }
}
