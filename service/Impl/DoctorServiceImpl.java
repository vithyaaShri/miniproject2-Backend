package com.miniproject2.miniproject2.service.Impl;

import com.miniproject2.miniproject2.dto.DoctorDto;
import com.miniproject2.miniproject2.entity.Doctor;
import com.miniproject2.miniproject2.repository.DoctorRepository;
import com.miniproject2.miniproject2.service.DoctorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private ModelMapper modelMapper;
    private DoctorRepository doctorRepository;

    //To Add Doctor Detail
    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor=modelMapper.map(doctorDto,Doctor.class);
        Doctor savedDoctor=doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor,DoctorDto.class);
    }
//To get Single Doctor By Id
    @Override
    public DoctorDto getDoctorById(Long id) {
        Doctor doctor=doctorRepository.findById(id).get();
        return modelMapper.map(doctor,DoctorDto.class);
    }
//To get All Doctor from
    @Override
    public List<DoctorDto> getAllDoctor() {
        List<Doctor> doctorList=doctorRepository.findAll();
        return doctorList.stream().map(doctor -> modelMapper.map(doctor,DoctorDto.class)).collect(Collectors.toList());
    }
//To Update Doctor Based On Id
    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, Long id) {
        Doctor doctor=doctorRepository.findById(id).get();
        doctor.setDoctorName(doctorDto.getDoctorName());
        doctor.setDepartment(doctorDto.getDepartment());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setLanguage(doctorDto.getLanguage());
        Doctor updatedDoctor=doctorRepository.save(doctor);
        return modelMapper.map(updatedDoctor,DoctorDto.class);
    }
//To Delete Doctor Based On id
    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor=doctorRepository.findById(id).get();
        doctorRepository.delete(doctor);

    }
//To find Doctor Based On Email
    @Override
    public DoctorDto findByEmail(String email) {
        Doctor doctor=doctorRepository.findByEmail(email);
        return modelMapper.map(doctor,DoctorDto.class);
    }
}
