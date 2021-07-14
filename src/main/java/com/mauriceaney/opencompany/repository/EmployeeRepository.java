package com.mauriceaney.opencompany.repository;

import com.mauriceaney.opencompany.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Maurice Aney
 * @date 09/07/2021 15:54
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
