package com.miniproject2.miniproject2.controller;

import com.miniproject2.miniproject2.dto.DoctorDto;
import com.miniproject2.miniproject2.entity.Doctor;
import com.miniproject2.miniproject2.repository.DoctorRepository;
import com.miniproject2.miniproject2.service.DoctorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@AllArgsConstructor
@CrossOrigin
//End Point for doctor
@RequestMapping("/api/doctor")
public class DoctorController{
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;

    //To post doctor to the backend
    @PostMapping
    public ResponseEntity<DoctorDto> saveDoctor(@RequestBody DoctorDto doctorDto)
    {
        DoctorDto savedDoctor=doctorService.addDoctor(doctorDto);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }
    //To get all Doctor Detail
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctor()
    {
        List<DoctorDto> allDoctor=doctorService.getAllDoctor();
        return new ResponseEntity<List<DoctorDto>>(allDoctor,HttpStatus.OK);
    }
    //To get single doctor detail
    @GetMapping("/{DoctorId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable("DoctorId")Long userId)
    {
        DoctorDto getDoctor=doctorService.getDoctorById(userId);
        return new ResponseEntity<DoctorDto>(getDoctor,HttpStatus.OK);
    }
    //Delete Doctor Based On id
    @DeleteMapping("/{id}")
    public  String deleteDoctor(@PathVariable("id")Long userId)
    {
        doctorService.deleteDoctor(userId);
        return "Doctor is deleted";
    }
    //To get Doctor detail based on email
    @GetMapping("/email/{email}")
    public ResponseEntity<DoctorDto> getDoctorByEmail(@PathVariable String email)
    {
        DoctorDto doctorDto=doctorService.findByEmail(email);
        return new ResponseEntity<DoctorDto>(doctorDto,HttpStatus.OK);
    }
    //To Change Doctor detail based on id
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorDto doctorDto)
    {
        DoctorDto updateDoctor=doctorService.updateDoctor(doctorDto,id);
        return new ResponseEntity<>(updateDoctor,HttpStatus.OK);
    }



}
