package com.example.EmployeeMS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("select obj from Employee obj where obj.salary = ?1")//jpql
	public Iterable<Employee> findEmployeeBySalary(Double salary);
}