package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SkillService skillService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Uncomment ONLY ONE method at a time.

        // ---------- MODULE 2 ----------

        // testCountryQueries();

        // testStockQueries();

        // testGetEmployee();

        // testAddEmployee();

        // testUpdateEmployee();

        // testGetDepartment();

        // testAddSkillToEmployee();

        // ---------- MODULE 3 ----------

        // testGetAllPermanentEmployees();

        // testGetAverageSalary();

        // testNativeQuery();

    }

    // =====================================================
    // COUNTRY QUERY METHODS
    // =====================================================

    private void testCountryQueries() {

        System.out.println("Countries containing 'ou'");
        countryRepository.findByNameContaining("ou")
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Countries containing 'ou' (Ascending)");
        countryRepository.findByNameContainingOrderByNameAsc("ou")
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Countries starting with Z");
        countryRepository.findByNameStartingWith("Z")
                .forEach(System.out::println);
    }

    // =====================================================
    // STOCK QUERY METHODS
    // =====================================================

    private void testStockQueries() {

        System.out.println("Facebook September 2019");

        List<Stock> stocks =
                stockRepository.findByCodeAndDateBetween(
                        "FB",
                        LocalDate.of(2019, 9, 1),
                        LocalDate.of(2019, 9, 30));

        stocks.forEach(System.out::println);

        System.out.println();

        System.out.println("Google Closing Price > 1250");

        stockRepository.findByCodeAndCloseGreaterThan(
                        "GOOGL",
                        new BigDecimal("1250"))
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Top 3 Highest Volume");

        stockRepository.findTop3ByOrderByVolumeDesc()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Top 3 Lowest Netflix");

        stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX")
                .forEach(System.out::println);

    }

    // =====================================================
    // MANY TO ONE
    // =====================================================

    private void testGetEmployee() {

        Employee employee = employeeService.get(1);

        System.out.println(employee);

        System.out.println(employee.getDepartment());

        System.out.println(employee.getSkillList());

    }

    // =====================================================
    // ADD EMPLOYEE
    // =====================================================

    private void testAddEmployee() {

        Employee employee = new Employee();

        employee.setName("John");

        employee.setSalary(50000);

        employee.setPermanent(true);

        employee.setDateOfBirth(new Date());

        Department department = departmentService.get(1);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);

    }

    // =====================================================
    // UPDATE EMPLOYEE
    // =====================================================

    private void testUpdateEmployee() {

        Employee employee = employeeService.get(1);

        Department department = departmentService.get(2);

        employee.setDepartment(department);

        employeeService.save(employee);

        System.out.println(employee);

    }

    // =====================================================
    // ONE TO MANY
    // =====================================================

    private void testGetDepartment() {

        Department department = departmentService.get(1);

        System.out.println(department);

        System.out.println(department.getEmployeeList());

    }

    // =====================================================
    // MANY TO MANY
    // =====================================================

    private void testAddSkillToEmployee() {

        Employee employee = employeeService.get(1);

        Skill skill = skillService.get(3);

        employee.getSkillList().add(skill);

        employeeService.save(employee);

        System.out.println(employee);

    }

    // =====================================================
    // HQL
    // =====================================================

    private void testGetAllPermanentEmployees() {

        List<Employee> employees =
                employeeService.getAllPermanentEmployees();

        System.out.println("Permanent Employees");

        employees.forEach(employee -> {

            System.out.println(employee);

            System.out.println(employee.getDepartment());

            System.out.println(employee.getSkillList());

            System.out.println("--------------------------------");

        });

    }

    // =====================================================
    // HQL AVG()
    // =====================================================

    private void testGetAverageSalary() {

        double average = employeeService.getAverageSalary(1);

        System.out.println("Average Salary = " + average);

    }

    // =====================================================
    // NATIVE QUERY
    // =====================================================

    private void testNativeQuery() {

        List<Employee> employees =
                employeeService.getAllEmployeesNative();

        employees.forEach(System.out::println);

    }

}