package com.beachproject.departmentservice.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.beachproject.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
  private List<Department> departments = new ArrayList<>();

  public Department addDepartment(Department department) {
    departments.add(department);
    return department;
  }

  public Department findById(Long id) {
    return departments.stream()
        .filter(a -> Objects.equals(a.getId(), id))
        .findFirst()
        .orElseThrow();
  }

  public List<Department> findAll(){
    return departments;
  }
}
