package com.miniproject2.miniproject2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Long id;
    private  String patientName;
    private Long contactNo;
    private String email;
    private int age;
    private String medicalHistory;
}
