package com.dejv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void runAtStart() {
        Employee employee = new Employee();
        employee.setFirstName("Kasia");
        employee.setLastName("Mila");
        employee.setSalary(new BigDecimal("5000.0"));
        employee.setEmploymentDate(LocalDate.of(2018,12,01));


        employeeRepository.save(employee);

        Iterable<Employee> kasias = employeeRepository.findByFirstName("Kasia");
        Employee kasia = kasias.iterator().next();

        System.out.println("Kasia to : " + kasia);

    }

}
