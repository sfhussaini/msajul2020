package com.example.EmployeeMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	private static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	static {
		/*
		 * Employee james = new Employee(); james.setEmpId(100);
		 * james.setName("James Cooper"); james.setDepartment("Training");
		 * james.setJob("Instructor"); employees.put(james.getEmpId(), james);
		 */
	}
	
	@Autowired
	EmployeeRepository repository;
	
	//http://localhost:8080/<context-root>/employees	
	@RequestMapping(path = "/employees", method = RequestMethod.GET)
	public Iterable<Employee> getEmployees(){
		EmployeeMsApplication.log.log(Level.INFO, "Entering EmployeeController.getEmployees");
		return repository.findAll();
		//return employees.values();
	}
	
	@RequestMapping(path = "/employees/{empId}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") Integer empId) {
		//Employee emp =  employees.get(empId);
		java.util.Optional<Employee> emp = repository.findById(empId);
		if(emp.isPresent() == false) {
			ResponseEntity<Employee> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return response;
		}else {
			ResponseEntity<Employee> response = new ResponseEntity<>(emp.get(), HttpStatus.OK);
			return response;
		}
	}
	
	//@RequestMapping(path = "/employees", method = RequestMethod.POST)
	@PostMapping("/employees")	
	public Employee createEmployee(@RequestBody Employee newEmp) {
		repository.save(newEmp);
		//employees.put(newEmp.getEmpId(), newEmp);
		return newEmp;
	}
	
	@RequestMapping(path = "/employees/{empId}", method = RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable("empId") Integer empId, @RequestBody Employee modifiedEmp) {
		repository.save(modifiedEmp);
		//employees.put(empId, modifiedEmp);
		return modifiedEmp;
	}
	
	@RequestMapping(path = "/employees/{empId}", method = RequestMethod.DELETE)
	public Employee deleteEmploeye(@PathVariable("empId") Integer empId) {
		Employee emp = repository.findById(empId).get();
		repository.deleteById(empId);
		//Employee emp = employees.get(empId);
		//employees.remove(empId);
		return emp;
	}
	
	@RequestMapping("/testQuery")
	public String testNewQuery() {
		Iterable<Employee> employees = repository.findEmployeeBySalary(new Double(12345));
		for(Employee emp: employees) {
			System.out.println(emp.getName());
		}
		return "Employees Found";
	}
}
