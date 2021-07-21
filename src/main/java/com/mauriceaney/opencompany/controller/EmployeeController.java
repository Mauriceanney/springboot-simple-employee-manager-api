package com.mauriceaney.opencompany.controller;

import com.mauriceaney.opencompany.model.Employee;
import com.mauriceaney.opencompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Maurice Aney
 * @date 12/07/2021 17:30
 */
@RestController
@RequestMapping("/api/v1/employee/")
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
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    /**
     * Get single employee
     * @param employeeId
     * @return Employee a single employee by the given id
     */
    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId){
        return employeeService.getEmployee(employeeId);
    }

    /**
     * Add new employee
     * @param employee
     * @return Employee a newly added employee
     */
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    /**
     * Update employee
     * @param employeeId id of employee to be update
     * @param employee employee to be update
     * @return Employee updated employee
     */
    @PutMapping("{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId, employee);
    }

    /**
     * Delete employee
     * @param employeeId id of employee to be delete
     */
    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
