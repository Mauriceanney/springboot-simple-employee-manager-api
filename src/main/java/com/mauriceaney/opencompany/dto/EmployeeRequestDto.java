package com.mauriceaney.opencompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maurice Aney
 * @date 21/07/2021 10:57
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class EmployeeRequestDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
