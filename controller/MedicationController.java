package com.miniproject2.miniproject2.controller;

import com.miniproject2.miniproject2.dto.DoctorDto;
import com.miniproject2.miniproject2.dto.MedicationDto;
import com.miniproject2.miniproject2.repository.MedicationRepository;
import com.miniproject2.miniproject2.service.MedicationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
//End Point for Medication
@RequestMapping("/api/medication")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;
    @Autowired
    private MedicationRepository medicationRepository;
    //To Post Medicine detail to Backend
    @PostMapping
    public ResponseEntity<MedicationDto> savePassenger(@RequestBody MedicationDto medicationDto)
    {
        MedicationDto savedMedication=medicationService.addMedication(medicationDto);
        return new ResponseEntity<>(savedMedication, HttpStatus.CREATED);
    }
//To get All the medicine detail
    @GetMapping
    public ResponseEntity<List<MedicationDto>> getAllDoctor()
    {
        List<MedicationDto> allMedication=medicationService.getAllMedication();
        return new ResponseEntity<List<MedicationDto>>(allMedication,HttpStatus.OK);
    }
    //To get a single medication list Based On id
    @GetMapping("/{MedicationId}")
    public ResponseEntity<MedicationDto> getDoctorById(@PathVariable("MedicationId")Long Id)
    {
        MedicationDto medicationDto=medicationService.getMedicationById(Id);
        return new ResponseEntity<MedicationDto>(medicationDto,HttpStatus.OK);
    }
    //Delete Medication Based On id
    @DeleteMapping("/{id}")
    public  String deleteMedication(@PathVariable("id")Long Id)
    {
        medicationService.deleteMedication(Id);
        return "Medication is deleted";
    }
    //Update Medication Based On id
    @PutMapping("/{id}")
    public ResponseEntity<MedicationDto> updateDoctor(@PathVariable("id") Long id, @RequestBody MedicationDto medicationDto)
    {
        MedicationDto medicationDto1=medicationService.updateMedication(medicationDto,id);
        return new ResponseEntity<>(medicationDto1,HttpStatus.OK);
    }


}
