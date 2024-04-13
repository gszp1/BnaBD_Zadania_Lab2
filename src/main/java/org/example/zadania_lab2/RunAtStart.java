package org.example.zadania_lab2;

import org.example.zadania_lab2.model.Employee;
import org.example.zadania_lab2.repository.EmployeeRepository;
import org.example.zadania_lab2.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class RunAtStart {

    @Bean
    public CommandLineRunner runner(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        return args -> {
            // Fill employee table with example employees
            employeeRepository.saveAll(Arrays.asList(
                            new Employee(
                                    "Tomasz",
                                    "Nowak",
                                    new BigDecimal("4500.00"),
                                    LocalDate.of(2024, 3, 2)
                            ),
                            new Employee(
                                    "Jan",
                                    "Kowalski",
                                    new BigDecimal("3699.45"),
                                    LocalDate.of(2019, 12, 23)
                            ),
                            new Employee(
                                    "Jakub",
                                    "Kowalski",
                                    new BigDecimal("7000.4"),
                                    LocalDate.of(2000, 7, 4)
                            ),
                            new Employee(
                                    "Andrzej",
                                    "Nowak",
                                    new BigDecimal("2132.2"),
                                    LocalDate.of(2012, 12, 12)
                            ),
                            new Employee(
                                    "tomasz",
                                    "Kowalski",
                                    new BigDecimal("4500.00"),
                                    LocalDate.of(2024, 3, 2)
                            )
                    )
            );

            // Retrieve all employees sorted by first name ascending and employment date descending
            System.out.println("\nRetrieve all employees sorted by first name ascending and employment date descending");
            List<Employee> employees = employeeService.getAllEmployeesOrderByFirstNameAscEmploymentDateDesc();
            employees.forEach(System.out::println);

            // Retrieve all employees sorted by last name ascending and salary descending
            System.out.println("\nRetrieve all employees sorted by last name ascending and salary descending");
            employees = employeeService.getAllEmployeesOrderByLastNameAscSalaryDesc();
            employees.forEach(System.out::println);

            // Retrieve all employees with first name Tomasz, ignore case
            System.out.println("\nRetrieve all employees with given first name, ignore case");
            employees = employeeService.getAllEmployeesByFirstNameNonCaseSensitive("Tomasz");
            employees.forEach(System.out::println);

            // Retrieve all employees with salary between 3000 and 6000
            System.out.println("\nRetrieve all employees with salary between 3000 and 6000");
            employees = employeeService.getAllEmployeesWithSalaryBetween(new BigDecimal("3000"),
                    new BigDecimal("6000")
            );
            employees.forEach(System.out::println);

        };
    }
}
