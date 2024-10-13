package com.example.EMS.services;

import com.example.EMS.persistence.DTO.EmployeeRequestDTO;
import com.example.EMS.persistence.DTO.EmployeeResponseDTO;
import com.example.EMS.persistence.DTO.EmployeeUpdateDTO;
import com.example.EMS.persistence.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO getEmployeeById(Long id);

    void deleteEmployee(Long id);

    List<EmployeeResponseDTO> getAllEmployees();

    Employee updateEmployee(EmployeeRequestDTO employeeRequestDTO);
}
