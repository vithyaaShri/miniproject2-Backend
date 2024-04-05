package com.miniproject2.miniproject2.service;

import com.miniproject2.miniproject2.dto.DoctorDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DoctorService {
    DoctorDto addDoctor(DoctorDto doctorDto);

    DoctorDto getDoctorById(Long id);

    List<DoctorDto> getAllDoctor();

    DoctorDto updateDoctor(DoctorDto doctorDto, Long id);

    void deleteDoctor(Long id);
    DoctorDto findByEmail(String email);

}
