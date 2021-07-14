package com.mauriceaney.opencompany.controller;

import com.mauriceaney.opencompany.model.Employee;
import com.mauriceaney.opencompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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


    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId){
        return employeeService.getEmployee(employeeId);
    }
}
