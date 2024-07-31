package EmployeeApplication.cal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EmployeeApplication.cal.service.EmployeeService;

import EmployeeApplication.cal.entity.Employee;
import EmployeeApplication.cal.entity.TaxSlip;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		System.out.println("employee " + employee);
		
		
		
		return employeeService.saveEmployee(employee);
		
	}
	
	@GetMapping("/taxPayable/{id}")
	public TaxSlip calculateTax(@PathVariable("id") long employeeId) {
		
		return employeeService.createTaxSlip(employeeId);
		
	}
	

}
