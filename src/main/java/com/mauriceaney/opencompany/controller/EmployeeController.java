package com.mauriceaney.opencompany.controller;

import com.mauriceaney.opencompany.dto.EmployeeRequestDto;
import com.mauriceaney.opencompany.dto.EmployeeResponseDto;
import com.mauriceaney.opencompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Maurice Aney
 * @date 12/07/2021 17:30
 */
@RestController
@RequestMapping(path = "/api/v1/employee/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * Get all employee
     * @return List<Employee> a list of all employee
     */
    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    /**
     * Get single employee
     * @param employeeId id of employee
     * @return Employee a single employee by the given id
     */
    @GetMapping(path = "{employeeId}")
    public EmployeeResponseDto getEmployee(@PathVariable Long employeeId){
        return employeeService.getEmployee(employeeId);
    }

    /**
     * Add new employee
     * @param employeeRequestDto employee to be create
     * @return Employee a newly added employee
     */
    @PostMapping
    public EmployeeResponseDto addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        return employeeService.addEmployee(employeeRequestDto);
    }

    /**
     * Update employee
     * @param employeeId id of employee to be update
     * @param employeeRequestDto employee to be update
     * @return Employee updated employee
     */
    @PutMapping(path = "{employeeId}")
    public EmployeeResponseDto updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeRequestDto employeeRequestDto){
        employeeRequestDto.setId(employeeId);
        return employeeService.updateEmployee(employeeId, employeeRequestDto);
    }

    /**
     * Delete employee
     * @param employeeId id of employee to be delete
     */
    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
