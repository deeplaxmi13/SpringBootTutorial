package com.deeplaxmi.SpringBoot.tutorial.service;

import com.deeplaxmi.SpringBoot.tutorial.entity.Department;
import com.deeplaxmi.SpringBoot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> fetchDepartmentList();

   public  Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public  void deleteDepartmentById(Long departmentId);

   public Department updateDepartmentById(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);
}
