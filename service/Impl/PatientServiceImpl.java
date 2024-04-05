package com.miniproject2.miniproject2.service.Impl;

import com.miniproject2.miniproject2.dto.PatientDto;
import com.miniproject2.miniproject2.entity.Patient;
import com.miniproject2.miniproject2.repository.PatientRepository;
import com.miniproject2.miniproject2.service.PatientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    public ModelMapper modelMapper;
    public PatientRepository patientRepository;
    //To Add Patient detail to repository
    @Override
    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient=modelMapper.map(patientDto,Patient.class);
        Patient savedpatient=patientRepository.save(patient);
        return modelMapper.map(savedpatient,PatientDto.class);
    }
//To get Patient Detail Based On Id
    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient=patientRepository.findById(id).get();
        return modelMapper.map(patient,PatientDto.class);
    }
//To get ALL patient detail in list
    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> list=patientRepository.findAll();
        return list.stream().map(listpatient->modelMapper.map(listpatient,PatientDto.class)).collect(Collectors.toList());
    }
//To Update Patient Detail Based on Id
    @Override
    public PatientDto updatePatient(PatientDto patientDto, Long id) {
        Patient patient=patientRepository.findById(id).get();
        patient.setPatientName(patientDto.getPatientName());
        patient.setContactNo(patientDto.getContactNo());
        patient.setAge(patientDto.getAge());
        patient.setEmail(patientDto.getEmail());
        patient.setMedicalHistory(patientDto.getMedicalHistory());
        Patient savedPatient=patientRepository.save(patient);
        return modelMapper.map(savedPatient,PatientDto.class);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient=patientRepository.findById(id).get();
        patientRepository.delete(patient);

    }

    @Override
    public PatientDto findByEmail(String email) {
        Patient patient=patientRepository.findByEmail(email);
        return modelMapper.map(patient,PatientDto.class);
    }


}
