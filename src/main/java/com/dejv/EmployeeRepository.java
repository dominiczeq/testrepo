package com.dejv;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
     Iterable <Employee> findByFirstName(String firstName);
     //List<Employee> findByFirstName(String firsName);

}
