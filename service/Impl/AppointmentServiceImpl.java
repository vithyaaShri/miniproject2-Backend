package com.miniproject2.miniproject2.service.Impl;

import com.miniproject2.miniproject2.dto.AppointmentDto;
import com.miniproject2.miniproject2.entity.Appointment;
import com.miniproject2.miniproject2.repository.AppointmentRepository;
import com.miniproject2.miniproject2.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    private ModelMapper modelMapper;

    //To Add Appointment to Repository
    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        Appointment appointment=modelMapper.map(appointmentDto,Appointment.class);
        Appointment savedappointment=appointmentRepository.save(appointment);
        return modelMapper.map(savedappointment,AppointmentDto.class);

    }
    //To get AppointmentBy id
    @Override
    public AppointmentDto getAppointmentById(Long id) {
        Appointment appointment=appointmentRepository.findById(id).get();
        return modelMapper.map(appointment,AppointmentDto.class);

    }
//To get All Appointment from repository
    @Override
    public List<AppointmentDto> getAllAppointment() {
        List<Appointment> appointmentList=appointmentRepository.findAll();
        return appointmentList.stream().map(list->modelMapper.map(list,AppointmentDto.class)).toList();
    }
    //To delete Appointment from Repository

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment=appointmentRepository.findById(id).get();
        appointmentRepository.delete(appointment);
    }
    //Cancel Appointment based on Boolean Value
    @Override
    public AppointmentDto cancelAppointment(Long id) {
        Appointment appointment=appointmentRepository.findById(id).get();
        if(!appointment.isCancelState()) {
            appointment.setCancelState(Boolean.TRUE);
        }
        Appointment updateAppointment=appointmentRepository.save(appointment);
        return modelMapper.map(updateAppointment,AppointmentDto.class);
    }

}
