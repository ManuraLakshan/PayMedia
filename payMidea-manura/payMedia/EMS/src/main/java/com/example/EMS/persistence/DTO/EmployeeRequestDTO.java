package com.example.EMS.persistence.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {
    private Long id;

    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String phone;

    @NotNull(message = "Department ID cannot be null")
    private Long department;
}
