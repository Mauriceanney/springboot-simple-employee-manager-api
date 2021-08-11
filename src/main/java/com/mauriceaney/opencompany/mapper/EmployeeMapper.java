package com.mauriceaney.opencompany.mapper;

import com.mauriceaney.opencompany.dto.EmployeeRequestDto;
import com.mauriceaney.opencompany.dto.EmployeeResponseDto;
import com.mauriceaney.opencompany.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Maurice Aney
 * @date 21/07/2021 11:04
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    EmployeeResponseDto employeeToEmployeeResponseDto(Employee employee);
    Employee employeeRequestDtoToEmployee(EmployeeRequestDto employeeRequestDto);
    
}
