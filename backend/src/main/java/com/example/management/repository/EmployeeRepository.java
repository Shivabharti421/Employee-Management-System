package com.example.management.repository;

import com.example.management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByNameContainingIgnoreCase(String name);
	List<Employee> findByDepartmentIgnoreCase(String department);
	List<Employee> findByCityIgnoreCase(String city);
	List<Employee> findBySalary(Double salary);
	

}