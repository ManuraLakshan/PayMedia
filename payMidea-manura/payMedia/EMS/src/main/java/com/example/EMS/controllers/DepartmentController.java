package com.example.EMS.controllers;

import com.example.EMS.persistence.DTO.DepartmentRequestDTO;
import com.example.EMS.persistence.DTO.DepartmentResponseDTO;
import com.example.EMS.persistence.DTO.DepartmentUpdateDTO;
import com.example.EMS.persistence.entities.Department;
import com.example.EMS.services.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
private final DepartmentService departmentService;

    @PostMapping
    public Department createDepartment(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        return departmentService.saveDepartment(departmentRequestDTO);
    }

    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping
    public Department updateDepartment(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        return departmentService.updateDepartmant(departmentRequestDTO);
    }
 
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
}
