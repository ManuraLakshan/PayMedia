package com.example.EMS.services.serviceImpl;

import com.example.EMS.persistence.DTO.EmployeeRequestDTO;
import com.example.EMS.persistence.DTO.EmployeeResponseDTO;
import com.example.EMS.persistence.DTO.EmployeeUpdateDTO;
import com.example.EMS.persistence.entities.Department;
import com.example.EMS.persistence.entities.Employee;
import com.example.EMS.persistence.repositories.DepartmentRepository;
import com.example.EMS.persistence.repositories.EmployeeRepository;
import com.example.EMS.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Employee saveEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = modelMapper.map(employeeRequestDTO, Employee.class);
        Department department = departmentRepository.findById(employeeRequestDTO.getDepartment()).orElse(null);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        modelMapper.typeMap(Employee.class, EmployeeResponseDTO.class).addMappings(mapper ->
                mapper.map(src -> src.getDepartment().getId(), EmployeeResponseDTO::setDepartmentId)
        );
        return employeeRepository.findById(id).map(employee -> modelMapper.map(employee, EmployeeResponseDTO.class))
                .orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        modelMapper.typeMap(Employee.class, EmployeeResponseDTO.class).addMappings(mapper ->
                mapper.map(src -> src.getDepartment().getId(), EmployeeResponseDTO::setDepartmentId)
        );
        return employeeRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDTO.class))
                .toList();
    }

    @Override
    public Employee updateEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee existing = employeeRepository.findById(employeeRequestDTO.getId()).orElse(null);
        modelMapper.map(employeeRequestDTO, existing);
        return employeeRepository.save(existing);
    }
}
