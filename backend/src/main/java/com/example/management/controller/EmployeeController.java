package com.example.management.controller;
//package com.example.employee_management.controller;

import com.example.management.dto.EmployeeDTO;
import com.example.management.entity.Employee;
import com.example.management.service.EmployeeService;
//import com.example.management.service.GetMapping;

import jakarta.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.*;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @Valid @RequestBody EmployeeDTO dto) {

        Employee employee = employeeService.createEmployee(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employee);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {

        List<Employee> employees =
                employeeService.getAllEmployee();

        return ResponseEntity.ok(employees);
    }
    //Search Employee
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployee(@RequestParam String name){
    	
    	List<Employee> employee = employeeService.searchEmployee(name);
    	return ResponseEntity.ok(employee);
    	
    }
    
    //Pagination
    @GetMapping("/page")
    public ResponseEntity<Page<Employee>> getEmployee(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size){
    	Pageable pageable = PageRequest.of(page, size);
    	Page<Employee> employee = employeeService.getEmployee(pageable);
    	return ResponseEntity.ok(employee);
    }
    
    @GetMapping("/filter/department")
    public ResponseEntity<List<Employee>> filterByDepartment(@RequestParam String department){
    	List<Employee> employees = employeeService.filterByDepartment(department);
    	return ResponseEntity.ok(employees);
    }
    
    @GetMapping("/filter/city")
    public ResponseEntity<List<Employee>> filterByCity(@RequestParam String city){
    	List<Employee> employees = employeeService.filterByCity(city);
    	return ResponseEntity.ok(employees);
    }
    
    @GetMapping("/filter/salary")
    public ResponseEntity<List<Employee>> filterBySalary(@RequestParam Double salary){
    	List<Employee> employees = employeeService.filterBySalary(salary);
    	return ResponseEntity.ok(employees);
    }
    

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable Long id) {

        Employee employee =
                employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employee);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDTO dto) {

        Employee employee =
                employeeService.updateEmployeeId(id, dto);

        return ResponseEntity.ok(employee);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(
            @PathVariable Long id) {

        employeeService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
