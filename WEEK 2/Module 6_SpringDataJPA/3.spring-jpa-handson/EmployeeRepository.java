package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // HQL - Permanent Employees
    @Query("""
            SELECT DISTINCT e
            FROM Employee e
            LEFT JOIN FETCH e.department
            LEFT JOIN FETCH e.skillList
            WHERE e.permanent = true
            """)
    List<Employee> getAllPermanentEmployees();

    // HQL - Average Salary by Department
    @Query("""
            SELECT AVG(e.salary)
            FROM Employee e
            WHERE e.department.id = :id
            """)
    double getAverageSalary(@Param("id") int id);

    // Native Query
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}