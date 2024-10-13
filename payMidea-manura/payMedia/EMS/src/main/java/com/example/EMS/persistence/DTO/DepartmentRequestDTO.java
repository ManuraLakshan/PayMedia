package com.example.EMS.persistence.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequestDTO {
    private Long id;
    private String name;
}
