package com.beachproject.employeeservice.controller;

import java.util.List;

import com.beachproject.employeeservice.model.Employee;
import com.beachproject.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  private EmployeeRepository employeeRepository;

  @PostMapping
  public Employee add(@RequestBody Employee employee) {
    LOGGER.info("Employee is Add {}:", employee);
    return employeeRepository.addDepartment(employee);
  }

  @GetMapping
  public List<Employee> findAll() {
    LOGGER.info("Employee find {}:");
    return employeeRepository.findAll();
  }

  @GetMapping("/{id}")
  public Employee findById(@PathVariable Long id){
    LOGGER.info("Employee find: id={}" ,id);
    return employeeRepository.findById(id);
  }

  @GetMapping("/department/{departmentId}")
  public List<Employee> findByDepartment(@PathVariable ("departmentId") Long departmentId){
    LOGGER.info("Employee find: departmentId={}" ,departmentId);
    return employeeRepository.findByDepartment(departmentId);
  }
}
