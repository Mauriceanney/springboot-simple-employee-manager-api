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
public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public Employee getEmployee(Long employeeId);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Long employeeId, Employee employee);
    public void deleteEmployee(Long employeeId);
}
