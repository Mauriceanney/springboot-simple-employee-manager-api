package com.mauriceaney.opencompany.service;

import com.mauriceaney.opencompany.model.Employee;
import com.mauriceaney.opencompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Maurice Aney
 * @date 12/07/2021 17:24
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * @return List<Employee> employee list
     */
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    /**
     * Get one employee by given id
     * @param employeeId id of employee to find
     * @return Employee a single employee with given
     */
    public Employee getEmployee(Long employeeId){
        return employeeRepository.findById(employeeId).get();
    }

}
