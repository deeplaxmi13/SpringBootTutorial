package com.deeplaxmi.SpringBoot.tutorial.repository;

import com.deeplaxmi.SpringBoot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
public Department findByDepartmentName(String departmentName);
public Department findByDepartmentNameIgnoreCase(String departName);
}
