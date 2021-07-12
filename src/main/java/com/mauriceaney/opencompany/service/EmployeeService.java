package com.mauriceaney.opencompany.service;

import com.mauriceaney.opencompany.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

/**
 * @author Maurice Aney
 * @date 12/07/2021 17:24
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
