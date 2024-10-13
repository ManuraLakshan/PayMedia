package com.example.EMS.persistence.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentUpdateDTO {
    private DepartmentRequestDTO departmentRequestDTO;
    private Long departmentId;
}
