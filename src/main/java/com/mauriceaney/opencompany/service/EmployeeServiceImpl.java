package com.mauriceaney.opencompany.service;

import com.mauriceaney.opencompany.dto.EmployeeRequestDto;
import com.mauriceaney.opencompany.dto.EmployeeResponseDto;
import com.mauriceaney.opencompany.exception.RessourceNotFoundException;
import com.mauriceaney.opencompany.mapper.EmployeeMapper;
import com.mauriceaney.opencompany.model.Employee;
import com.mauriceaney.opencompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Maurice Aney
 * @date 21/07/2021 13:29
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    /**
     * Get a list of all employees
     * @return List<EmployeeResponseDto> employee list
     */
    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::employeeToEmployeeResponseDto).collect(Collectors.toList());
    }

    /**
     * Get one employee by given id
     * @param employeeId id of employee to find
     * @return Employee a single employee with given
     */
    @Override
    public EmployeeResponseDto getEmployee(Long employeeId) throws RessourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RessourceNotFoundException("employee with id " +employeeId+ " not found !"));
        return employeeMapper.employeeToEmployeeResponseDto(employee);
    }

    /**
     * Add new employee
     * @param employeeRequestDto employee to add
     * @return EmployeeResponseDto newly created employee
     */
    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeMapper.employeeRequestDtoToEmployee(employeeRequestDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeResponseDto(savedEmployee);
    }

    /**
     * Update employee
     * @param employeeRequestDto   employee to update
     * @return updated employee
     */
    @Override
    public EmployeeResponseDto updateEmployee(EmployeeRequestDto employeeRequestDto) throws RessourceNotFoundException{
        Employee employee = employeeRepository.findById(employeeRequestDto.getId())
                .orElseThrow(() -> new RessourceNotFoundException("Employee with id " + employeeRequestDto.getId().toString() + " not found !"));
        employee = employeeMapper.employeeRequestDtoToEmployee(employeeRequestDto);
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeResponseDto(updatedEmployee);
    }

    /**
     * Delete employee
     * @param employeeId id of employee to be delete
     */
    @Override
    public void deleteEmployee(Long employeeId) throws RessourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->new RessourceNotFoundException("Employee with id " + employeeId + " not found !"));
        employeeRepository.deleteById(employee.getId());
    }
}
