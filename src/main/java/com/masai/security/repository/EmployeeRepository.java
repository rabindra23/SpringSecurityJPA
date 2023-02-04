package com.masai.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.security.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public Employee findByUserName(String username);
}
