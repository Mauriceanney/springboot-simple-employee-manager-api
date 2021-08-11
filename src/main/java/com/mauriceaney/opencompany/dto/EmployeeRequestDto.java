package com.mauriceaney.opencompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Maurice Aney
 * @date 21/07/2021 10:57
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class EmployeeRequestDto {
    private Long id;
    @NotEmpty
    @Size(min = 3, message = "First Name must be at least 3 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 3, message = "Last  Name must be at least 3 characters")
    private String lastName;
    @NotEmpty
    @Email(message = "Email must be a valid email address")
    private String email;
    @Size(min = 10, message = "Phone number must be at least 10 characters")
    private String phone;
}
