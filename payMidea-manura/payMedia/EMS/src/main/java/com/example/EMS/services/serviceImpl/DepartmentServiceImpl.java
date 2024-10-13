package com.example.EMS.services.serviceImpl;

import com.example.EMS.persistence.DTO.DepartmentRequestDTO;
import com.example.EMS.persistence.DTO.DepartmentResponseDTO;
import com.example.EMS.persistence.DTO.DepartmentUpdateDTO;
import com.example.EMS.persistence.DTO.EmployeeResponseDTO;
import com.example.EMS.persistence.entities.Department;
import com.example.EMS.persistence.repositories.DepartmentRepository;
import com.example.EMS.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Department saveDepartment(DepartmentRequestDTO departmentRequestDTO) {
        Department department = modelMapper.map(departmentRequestDTO, Department.class);
        return departmentRepository.save(department);
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long id) {
        return departmentRepository.findById(id).map(department -> modelMapper.map(department, DepartmentResponseDTO.class)).orElse(null);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentRepository.findAll().stream().map( department -> modelMapper.map(department, DepartmentResponseDTO.class))
                .toList();
    }

    @Override
    public Department updateDepartmant(DepartmentRequestDTO departmentRequestDTO) {
        Department existing = departmentRepository.findById(departmentRequestDTO.getId()).orElse(null);
        modelMapper.map(departmentRequestDTO, existing);
        return departmentRepository.save(existing);
    }
}
