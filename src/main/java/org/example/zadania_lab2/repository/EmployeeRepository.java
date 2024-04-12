package org.example.zadania_lab2.repository;

import org.example.zadania_lab2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}