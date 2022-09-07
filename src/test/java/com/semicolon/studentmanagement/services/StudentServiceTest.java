package com.semicolon.studentmanagement.services;
import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.DeleteStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.UpdateResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;
import com.semicolon.studentmanagement.dto.requests.UpdateStudentRequest;
import com.semicolon.studentmanagement.exceptions.StudentExistException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    @DisplayName("Add a student")
    public void testThatAStudentCanBeAddedToTheSchoolDatabase(){
        AddStudentRequest request = AddStudentRequest.builder()
                .firstName("Love")
                .lastName("Hope")
                .email("love@gmail.com")
                .address("juno")
                .dob("2008-06-09 00:00")
                .phoneNumber("9876543")
                .build();
        AddStudentResponse response = service.addStudent(request);
        assertNotNull(response);
        assertEquals("Love ,Welcome to Semicolon.", response.getMessage());
    }

    @Test
    @DisplayName("Get all students")
    public void getAllStudentTest(){
       List< Student> student = service.getAllStudent();
       assertEquals(2, student.size());
    }

    @Test
    @DisplayName("Delete a student from database")
    public void testThatAStudentCanBeDeleted(){
        DeleteStudentResponse student = service.delete(1L);
        assertThrows(StudentExistException.class, ()->service.delete(1L));
    }

    @Test
    @DisplayName("Update a student detail")
    public void testThatStudentDetailCanBeUpdated(){
        UpdateStudentRequest request = new UpdateStudentRequest();
        request.setEmail("hopeL@gmail.com");
        UpdateResponse response = service.updateStudent(3, request);
        assertEquals("updated Love" , response.getMessage());
    }

    @Test
    @DisplayName("find a student by first name and last name")
    public void findAStudentByNameTest(){
        Student student = service.findStudentByName("love", "Hope");
        assertEquals("hopeL@gmail.com", student.getEmail());
    }

}