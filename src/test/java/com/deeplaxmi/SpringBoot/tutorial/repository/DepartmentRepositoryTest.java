package com.deeplaxmi.SpringBoot.tutorial.repository;

import com.deeplaxmi.SpringBoot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //data will be flushed out after use. Temporary storage //or you can run unit tests in entirely different database //or go with containerized db
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("ME").departmentAddress("Solapur").departmentCode("ME-09").build();
        testEntityManager.persist(department);
    }

    @Test
    public void whenTestFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getDepartmentName(),"ME");
    }
}