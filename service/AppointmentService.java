package com.miniproject2.miniproject2.service;

import com.miniproject2.miniproject2.dto.AppointmentDto;
import com.miniproject2.miniproject2.dto.DoctorDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto addAppointment(AppointmentDto appointmentDto);

    AppointmentDto getAppointmentById(Long id);

    List<AppointmentDto> getAllAppointment();
    void deleteAppointment(Long id);

    AppointmentDto cancelAppointment(Long id);
}
