package com.example.management.service;



import com.example.management.dto.EmployeeDTO;
import com.example.management.entity.Employee;
import com.example.management.exception.EmployeeNotFoundException;
import com.example.management.repository.EmployeeRepository;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    //
    

    // CREATE
    public Employee createEmployee(EmployeeDTO dto) {

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        employee.setCity(dto.getCity());

        return employeeRepository.save(employee);
    }

    // GET ALL
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    
    //Pagination
    public Page<Employee> getEmployee(Pageable pageable ){
    	return employeeRepository.findAll(pageable);
    }
    
    //Filter by Department
    public List<Employee> filterByDepartment(String department){
    	
    	return employeeRepository.findByDepartmentIgnoreCase(department);
    }
    
    // filter by city
    public List<Employee> filterByCity(String city){
    	return employeeRepository.findByCityIgnoreCase(city);
    }
    
    //filter by Salary
    public List<Employee> filterBySalary(Double salary){
    	return employeeRepository.findBySalary(salary);
    }
   
    
    //Search Employee
    public List<Employee> searchEmployee(String name){
    	return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    

    // GET BY ID
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id: " + id
                        )
                );
    }

    // UPDATE
    public Employee updateEmployeeId(Long id, EmployeeDTO dto) {

        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setName(dto.getName());
        existingEmployee.setEmail(dto.getEmail());
        existingEmployee.setPhone(dto.getPhone());
        existingEmployee.setDepartment(dto.getDepartment());
        existingEmployee.setSalary(dto.getSalary());
        existingEmployee.setCity(dto.getCity());

        return employeeRepository.save(existingEmployee);
    }

    // DELETE
    public void deleteById(Long id) {

        Employee employee = getEmployeeById(id);

        employeeRepository.delete(employee);
    }
}
