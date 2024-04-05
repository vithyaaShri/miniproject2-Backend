package com.miniproject2.miniproject2.repository;

import com.miniproject2.miniproject2.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
