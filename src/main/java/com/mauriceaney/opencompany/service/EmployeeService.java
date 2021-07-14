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
     * Get a list of all employees
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

    /**
     * Add new employee
     * @param employee employee to add
     * @return newly created employee
     */
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Update employee
     * @param employee employee to update
     * @return updated employee
     */
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        /*if (!optionalEmployee.isPresent()){
            return ;
        }*/
        return employeeRepository.save(employee);
    }

    /**
     * Delete employee
     * @param employeeId id of employee to be delete
     */
    public void deleteEmployee(Long employeeId) {
         employeeRepository.deleteById(employeeId);
    }
}
