package com.miniproject2.miniproject2.controller;

import com.miniproject2.miniproject2.dto.AppointmentDto;
import com.miniproject2.miniproject2.dto.DoctorDto;
import com.miniproject2.miniproject2.repository.AppointmentRepository;
import com.miniproject2.miniproject2.repository.DoctorRepository;
import com.miniproject2.miniproject2.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
//End Points to register Appointment Detail
@RequestMapping("/api/Appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentRepository appointmentRepository;

  //To save Appoint details to database
    @PostMapping
    public ResponseEntity<AppointmentDto> saveAppointment(@RequestBody AppointmentDto appointmentDto)
    {
        AppointmentDto savedAppointment=appointmentService.addAppointment(appointmentDto);
        return new ResponseEntity<AppointmentDto>(savedAppointment, HttpStatus.CREATED);
    }
    //Get all Appointment from backend
    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllDoctor()
    {
        List<AppointmentDto> allAppointment=appointmentService.getAllAppointment();
        return new ResponseEntity<List<AppointmentDto>>(allAppointment,HttpStatus.OK);
    }
    //To get one single Appointment based on id
    @GetMapping("/{AppointmentId}")
    public ResponseEntity<AppointmentDto> getDoctorById(@PathVariable("AppointmentId")Long Id)
    {
        AppointmentDto getAppointment=appointmentService.getAppointmentById(Id);
        return new ResponseEntity<AppointmentDto>(getAppointment,HttpStatus.OK);
    }
    //Delete Appointment Based On id
    @DeleteMapping("/{id}")
    public  String deleteDoctor(@PathVariable("id")Long Id)
    {
        appointmentService.deleteAppointment(Id);
        return "Appointment is deleted";
    }

    //To edit all the Appointment details
    @PutMapping("/cancelAppointment/{id}")
    public ResponseEntity<AppointmentDto> cancelTicket(@PathVariable("id") Long id){
        AppointmentDto updatedAppointment=appointmentService.cancelAppointment(id);
        return ResponseEntity.ok(updatedAppointment);

    }

}
