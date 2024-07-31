package EmployeeApplication.cal.entity;

import org.springframework.stereotype.Component;

@Component
public class TaxSlip {
	private long employeeId;
	private String firstName;
	private String lastName;
	private float yearlySalary;
	private float taxAmount;
	private float cessAmount;
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public float getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(float yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public float getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}
	public float getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(float cessAmount) {
		this.cessAmount = cessAmount;
	}
	
	
	

}
