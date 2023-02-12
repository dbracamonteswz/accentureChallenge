package com.mx.accenture.springmvc.example;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mx.accenture.springmvc.example.controller.StudentController;
import com.mx.accenture.springmvc.example.dto.CourseDTO;
import com.mx.accenture.springmvc.example.service.ICourseService;
import com.mx.accenture.springmvc.example.service.IStudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@AutoConfigureMockMvc
public class CourseTest {

    //MockMvc component is provided by Spring to make calls to the Spring MVC API and assert different properties like status code and received response.
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    private ICourseService iCursoService; // This will mock a Spring Bean and Inject it where is needed
    
    @MockBean
    private IStudentService iStudentService; // This will mock a Spring Bean and Inject it where is needed

    @WithMockUser("admin")
    @Test
    void getAllCoursesTest() throws Exception {
    	
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/course/list"))
                .andExpect(status().isOk()).andReturn(); //check is response status is 200
        assertEquals(200, result.getResponse().getStatus());
    }

    @WithMockUser("admin")
    @Test
    void deleteCourseByIdTest() throws Exception{
        MvcResult result =mockMvc.perform(MockMvcRequestBuilders.get("/course/delete/5"))
                .andExpect(status().isNoContent()) //check is response status is 200
                .andReturn();
        assertEquals(204, result.getResponse().getStatus());
    }

    @WithMockUser("admin")
    @Test
    void addCourse() throws Exception{
    	Gson gson = new Gson();
    	CourseDTO courseDTO = new CourseDTO();
    	courseDTO.setNameCourse("Test Course");
    	courseDTO.setNameTeacher("Teacher Name");
        String json = gson.toJson(courseDTO);
    	
        MvcResult result =mockMvc.perform(MockMvcRequestBuilders.post("/course").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()) //check is response status is 200
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }
    
    @WithMockUser("admin")
    @Test
    void updateCourse() throws Exception{
    	Gson gson = new Gson();
    	CourseDTO courseDTO = new CourseDTO();
    	courseDTO.setIdCourse(1);
    	courseDTO.setNameCourse("Test Course");
    	courseDTO.setNameTeacher("Teacher Name");
        String json = gson.toJson(courseDTO);
    	
        MvcResult result =mockMvc.perform(MockMvcRequestBuilders.put("/course").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()) //check is response status is 200
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }
}