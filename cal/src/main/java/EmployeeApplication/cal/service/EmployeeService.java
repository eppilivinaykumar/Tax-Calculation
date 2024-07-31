package EmployeeApplication.cal.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EmployeeApplication.cal.Repository.EmployeeDao;
import EmployeeApplication.cal.entity.Employee;
import EmployeeApplication.cal.entity.TaxSlip;

@Service
public class EmployeeService {
	private EmployeeDao employeeDao;
	private TaxSlip taxslip;
	private int taxableMonths;
	
	
	@Autowired
	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
		
	}
	public Employee saveEmployee(Employee employee) {
		return employeeDao.save(employee);
	}
	
	
	@Autowired
	public void setTaxSlip(TaxSlip taxslip) {
		this.taxslip = taxslip;
		
	}
	
	public TaxSlip createTaxSlip(Long employeeId) {
		Employee employee = employeeDao.findById(employeeId).orElseThrow(
				() -> new RuntimeException("Employee not found with " + employeeId));
		taxslip.setEmployeeId(employeeId);
		taxslip.setFirstName(employee.getFirstName());
		taxslip.setLastName(employee.getLastName());
		taxslip.setYearlySalary(taxableMonths);
		
		
		
		
				
		
		return taxslip;
		
	}
	
	public float calculateTax(float yearlysalary) {
		
		float tax =0;
		float taxableIncome =0;
		
		while(yearlysalary > 0) {
			if(yearlysalary > 1000000) {
				taxableIncome = yearlysalary - 1000000;
				yearlysalary -= taxableIncome;
				tax += 0.2*(taxableIncome);
			}
			else if(yearlysalary > 500000) {
				taxableIncome = yearlysalary - 250000;
				yearlysalary -= taxableIncome;
				tax += 0.05*(taxableIncome);
				
				}
			else if(yearlysalary < 250000) {
				taxableIncome =0;
				yearlysalary = 0;
				
			}
		}
		
		return taxableIncome;
		
		
	}
	
	private float calculateYearlySalary(float monthlySalary,LocalDate dateOfJoining) {
		
		Period period = Period.between(dateOfJoining, LocalDate.now());
		int numberOfMonthsWorkedInFinancialYear = period.getMonths();
		
		taxableMonths = numberOfMonthsWorkedInFinancialYear >= 12 ? 12 : numberOfMonthsWorkedInFinancialYear;
		
		
		
		
		return (taxableMonths * monthlySalary);
		
	}
	
	private float calculateCessAmount(float yearlySalary) {
		float cessEligibleAmount = 2500000;
		if(yearlySalary > cessEligibleAmount) {
			return (float)(0.02*(yearlySalary - cessEligibleAmount));
			
		}
		return 0;
		
	}
	
	
	
	
	
	
	
	
	

}
