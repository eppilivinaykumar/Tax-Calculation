package EmployeeApplication.cal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import EmployeeApplication.cal.entity.Employee;

public interface EmployeeDao  extends JpaRepository<Employee, Long>{
	
	

}
