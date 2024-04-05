package com.miniproject2.miniproject2.controller;

import com.miniproject2.miniproject2.dto.DoctorDto;
import com.miniproject2.miniproject2.dto.PatientDto;
import com.miniproject2.miniproject2.entity.Patient;
import com.miniproject2.miniproject2.repository.PatientRepository;
import com.miniproject2.miniproject2.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;
    //To Save Patience detail
    @PostMapping
    public ResponseEntity<PatientDto> savePatience(@RequestBody PatientDto patientDto)
    {
        PatientDto savedPatient=patientService.addPatient(patientDto);
        return new ResponseEntity<PatientDto>(savedPatient, HttpStatus.CREATED);
    }
    //To get All the Patience
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatience()
    {
        List<PatientDto> allPatient=patientService.getAllPatient();
        return new ResponseEntity<List<PatientDto>>(allPatient,HttpStatus.OK);
    }

    //To get Single Patience Based on id
    @GetMapping("/{PatientId}")
    public ResponseEntity<PatientDto> getPassengerById(@PathVariable("PatientId")Long Id)
    {
        PatientDto patientDto=patientService.getPatientById(Id);
        return new ResponseEntity<PatientDto>(patientDto,HttpStatus.OK);
    }
    //To delete Patient based on Id
    @DeleteMapping("/{id}")
    public  String deletePatient(@PathVariable("id")Long userId)
    {
        patientService.deletePatient(userId);
        return "Patient is deleted";
    }
    //To get Patient detail based on email
    @GetMapping("/email/{email}")
    public ResponseEntity<PatientDto> getPatientByEmail(@PathVariable String email)
    {
        PatientDto patientDto=patientService.findByEmail(email);
        return new ResponseEntity<PatientDto>(patientDto,HttpStatus.OK);
    }
    //To Change Patient detail based on id
    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable("id") Long id, @RequestBody PatientDto patientDto)
    {
        PatientDto patientDto1=patientService.updatePatient(patientDto,id);
        return new ResponseEntity<>(patientDto1,HttpStatus.OK);
    }

}
