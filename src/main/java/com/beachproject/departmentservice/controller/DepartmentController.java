package com.beachproject.departmentservice.controller;

import java.util.List;

import com.beachproject.departmentservice.client.EmployeeClient;
import com.beachproject.departmentservice.model.Department;
import com.beachproject.departmentservice.repository.DepartmentRepository;
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
@RequestMapping("/department")
public class DepartmentController {

  private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  private EmployeeClient employeeClient;

  @PostMapping
  public Department add(@RequestBody Department department){
    LOGGER.info("Department is Add {}:" ,department);
    return departmentRepository.addDepartment(department);
  }

  @GetMapping
  public List<Department> findAll(){
    LOGGER.info("Department find {}:");
    return departmentRepository.findAll();
  }

  @GetMapping("/{id}")
  public Department findById(@PathVariable Long id){
    LOGGER.info("Department find: {}" ,id);
    return departmentRepository.findById(id);
  }

  @GetMapping("/with-employee")
  public List<Department> findAllWithEmployees(){
    LOGGER.info("Department find {}:");
    List<Department> departments = departmentRepository.findAll();
    departments.forEach(department -> department.setEmployees(employeeClient.findByDepartment(department.getId())));
    return departments;
  }

}
