package com.miniproject2.miniproject2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    private String doctorName;
    private String department;
    private String qualification;
    private String language;
    private String email;

}
