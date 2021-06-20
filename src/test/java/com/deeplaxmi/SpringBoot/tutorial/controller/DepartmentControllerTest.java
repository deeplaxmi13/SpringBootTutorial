package com.deeplaxmi.SpringBoot.tutorial.controller;

import com.deeplaxmi.SpringBoot.tutorial.entity.Department;
import com.deeplaxmi.SpringBoot.tutorial.error.DepartmentNotFoundException;
import com.deeplaxmi.SpringBoot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().departmentName("IT").departmentCode("IT-06").departmentAddress("Solapur").departmentId(1L).build();
    }

    @Test
    @DisplayName(" Save Department testcase")
    void saveDepartment() throws Exception {
       Department inputdepartment = Department.builder().departmentName("IT").departmentCode("IT-06").departmentAddress("Solapur").departmentId(1L).build();
        Mockito.when(departmentService.saveDepartment(inputdepartment)).thenReturn(department);

        //call end point
        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content(" {\n" +
                "     \"departmentName\": \"IT\",\n" +
                "        \"departmentAddress\": \"Solapur\",\n" +
                "        \"departmentCode\": \"IT-06\"\n" +
                "    }")).andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentList() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1l)).thenReturn(department);

        //get api call
       mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}