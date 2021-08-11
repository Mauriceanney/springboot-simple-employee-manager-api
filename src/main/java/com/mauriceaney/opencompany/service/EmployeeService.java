package com.mauriceaney.opencompany.service;

import com.mauriceaney.opencompany.dto.EmployeeRequestDto;
import com.mauriceaney.opencompany.dto.EmployeeResponseDto;
import com.mauriceaney.opencompany.exception.RessourceNotFoundException;

import java.util.List;

/**
 * @author Maurice Aney
 * @date 12/07/2021 17:24
 */
public interface EmployeeService {

    List<EmployeeResponseDto> getAllEmployees();
    EmployeeResponseDto getEmployee(Long employeeId) throws RessourceNotFoundException;
    EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto updateEmployee(EmployeeRequestDto employeeRequestDto) throws RessourceNotFoundException;
    void deleteEmployee(Long employeeId) throws RessourceNotFoundException;
}
