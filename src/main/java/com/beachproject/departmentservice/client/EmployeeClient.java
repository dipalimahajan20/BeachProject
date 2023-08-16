package com.beachproject.departmentservice.client;

import java.util.List;

import com.beachproject.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface EmployeeClient {

  @GetExchange("/employee/department/{departmentId}")
  public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
