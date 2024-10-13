package com.example.EMS.controllers;

import com.example.EMS.persistence.DTO.EmployeeRequestDTO;
import com.example.EMS.persistence.DTO.EmployeeResponseDTO;
import com.example.EMS.persistence.DTO.EmployeeUpdateDTO;
import com.example.EMS.persistence.entities.Employee;
import com.example.EMS.services.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.saveEmployee(employeeRequestDTO);
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping
    public Employee updateEmployee( @Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.updateEmployee(employeeRequestDTO);

    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
