package com.example.EMS.persistence.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Long departmentId;
}
