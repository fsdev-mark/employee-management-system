package com.dev.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.model.Employee;
import com.dev.repositories.EmployeeRepository;
import com.dev.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private final EmployeeRepository repository;
	
	EmployeeServiceImpl(EmployeeRepository repository) {
		
		this.repository = repository;
		
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return repository.findAll();
	}
	
	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		
		return repository.findById(id);
		
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		return repository.save(employee);
	}
	
	@Override
	public Employee updateEmployee(Long id, Employee employeeDetails) {
		
		return repository.findById(id).map(employee -> {
			
			employee.setEmployeeId(employeeDetails.getEmployeeId());
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setPosition(employeeDetails.getPosition());
			employee.setSalary(employeeDetails.getSalary());
			employee.setContactNumber(employeeDetails.getContactNumber());
//			employee.setStatus(employeeDetails.getStatus());
			return repository.save(employee);
			
		}).orElseThrow(() -> new RuntimeException("Employee not Found"));
	}
	
	@Override
	public void deleteEmployee(Long id) {
		
		repository.deleteById(id);
	}
}
