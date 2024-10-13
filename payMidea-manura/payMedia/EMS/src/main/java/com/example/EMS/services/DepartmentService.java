package com.example.EMS.services;

import com.example.EMS.persistence.DTO.DepartmentRequestDTO;
import com.example.EMS.persistence.DTO.DepartmentResponseDTO;
import com.example.EMS.persistence.DTO.DepartmentUpdateDTO;
import com.example.EMS.persistence.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(DepartmentRequestDTO departmentRequestDTO);

    DepartmentResponseDTO getDepartmentById(Long id);

    void deleteDepartment(Long id);

    List<DepartmentResponseDTO> getAllDepartments();

    Department updateDepartmant(DepartmentRequestDTO departmentRequestDTO);
}
