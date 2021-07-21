package com.mauriceaney.opencompany;

import com.mauriceaney.opencompany.model.Employee;
import com.mauriceaney.opencompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpencompanyApplication implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public OpencompanyApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OpencompanyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.save(new Employee(1L, "Maurice", "Aney", "mauriceaney@gmail.com", "0748920823"));
        employeeRepository.save(new Employee(2L, "Koffi", "Franck", "koffi.franck@gmail.com", "0748920823"));
    }
}
