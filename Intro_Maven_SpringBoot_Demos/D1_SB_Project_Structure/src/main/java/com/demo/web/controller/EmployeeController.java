package com.demo.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bussiness.bean.Employee;
import com.demo.dao.EmployeeDAO;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@GetMapping(value = "emp/controller/getDetails",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployeeDetails() {
		List<Employee> listEmployee = new ArrayList<Employee>(employeeDAO.getAllEmployee());
		
		return new ResponseEntity<List<Employee>>(listEmployee,HttpStatus.OK);
	}

	@GetMapping(value = "emp/controller/getDetailsById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId) {
		Employee employee = employeeDAO.getEmployeeDetailsById(myId);

		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/emp/controller/addEmp",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		int count=employeeDAO.addEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully with id:" + count,HttpStatus.CREATED);
	}

	@PutMapping(value = "/emp/controller/updateEmp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody  Employee employee) {
		if (employeeDAO.getEmployeeDetailsById(employee.getEmployeeId()) == null) {
			Employee employee2 = null;
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Employee updated = employeeDAO.updateEmployee(employee);
		return new ResponseEntity<Employee>(updated, HttpStatus.OK);
	}

	@DeleteMapping(value = "/emp/controller/deleteEmp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int myId) {
		if (employeeDAO.getEmployeeDetailsById(myId) == null) {
			Employee employee2 = null;
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Employee employee = employeeDAO.removeEmployee(myId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@Override
	public String toString() {
		return "I am from EmployeeController toString()";
	}
}