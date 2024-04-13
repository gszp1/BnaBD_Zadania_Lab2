package org.example.zadania_lab2.repository;

import org.example.zadania_lab2.model.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByOrderByIdAsc();

    List<Employee> findAllByOrderByIdDesc();

    Page<Employee> findAllByOrderByIdAsc(Pageable pageable);

    Page<Employee> findAllByOrderByIdDesc(Pageable pageable);

    List<Employee> findByFirstNameIgnoreCase(String firstName);

    List<Employee> findBySalaryBetween(BigDecimal minSalary, BigDecimal maxSalary);
}