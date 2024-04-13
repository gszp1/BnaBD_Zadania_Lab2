package org.example.zadania_lab2.service;

import org.example.zadania_lab2.model.Employee;
import org.example.zadania_lab2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployeesOrderByLastNameAscSalaryDesc() {
        return employeeRepository.findAll(Sort.by(
                new Sort.Order(Sort.Direction.ASC, "lastName"),
                new Sort.Order(Sort.Direction.DESC, "salary")
        ));
    }

    public List<Employee> getAllEmployeesOrderByFirstNameAscEmploymentDateDesc() {
        return employeeRepository.findAll(Sort.by(
                new Sort.Order(Sort.Direction.ASC, "firstName"),
                new Sort.Order(Sort.Direction.DESC, "employmentDate")
        ));
    }

    public List<Employee> getAllEmployeesByFirstNameNonCaseSensitive(String firstName) {
        return employeeRepository.findByFirstNameIgnoreCase(firstName);
    }
}
