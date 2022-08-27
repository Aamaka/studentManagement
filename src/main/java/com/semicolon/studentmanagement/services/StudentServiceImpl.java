package com.semicolon.studentmanagement.services;
import com.semicolon.studentmanagement.Mapper;
import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.data.repositories.StudentRepository;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.DeleteStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.UpdateResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;
import com.semicolon.studentmanagement.dto.requests.UpdateStudentRequest;
import com.semicolon.studentmanagement.exceptions.StudentExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) {
        if(studentRepository.existsByEmail(request.getEmail()))throw new StudentExistException("email taken");
        Student student = new Student();
        Mapper.map(request, student);

        String studentId = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        studentId = "ST"+ studentId.substring(1, 4);

        student.setStudentId(studentId);


        if(studentRepository.existsByStudentId(student.getStudentId())){
            String studentId1;
            studentId1 ="ST"+ studentId.substring(1, 4);

            student.setStudentId(studentId1);
        }

        Student saveStudent = studentRepository.save(student);
        AddStudentResponse response = new AddStudentResponse();
        Mapper.map(saveStudent, response);
        return response;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public DeleteStudentResponse delete(long id) {
        Optional<Student> exist = studentRepository.findById(id);
        if(exist.isEmpty()){
            throw new StudentExistException("student does not exist");
        }
        else {
            studentRepository.deleteById(id);
            DeleteStudentResponse response = new DeleteStudentResponse();
            response.setMessage("Deletion successful");
            return response;
        }
    }

    @Override @Transactional
    public UpdateResponse updateStudent(long id, UpdateStudentRequest request) {
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new StudentExistException("student with id "+ id + "does not exist"));
        UpdateResponse response = new UpdateResponse();


        if(request.getFirstName() != null && request.getFirstName().length() > 0 && !Objects.equals(student.getFirstName(), request.getFirstName())){
            student.setFirstName(request.getFirstName());
            response.setMessage("updated "+ student.getFirstName());
        }
        if(request.getLastName() != null && request.getLastName().length() > 0 && !Objects.equals(student.getLastName(), request.getLastName())){
            student.setLastName(request.getLastName());
            response.setMessage("updated "+ student.getLastName());
        }

        if(request.getEmail() != null && request.getEmail().length() > 0 && !Objects.equals(student.getEmail(), request.getEmail())){

            Optional<Student> student1 = studentRepository.findByEmail(request.getEmail());
            if(student1.isPresent()){
                throw new StudentExistException("email taken");
            }
            student.setEmail(request.getEmail());
            response.setMessage("updated "+ student.getFirstName());
        }

        return response;
    }

    @Override
    public Student findStudentByName(String firstName, String lastName) {
        Optional<Student> student = studentRepository.findStudentByFirstNameAndLastName(firstName, lastName);
        Student study = student.get();
        if(firstName.equals(study.getFirstName())
                && lastName.equals(study.getLastName())
                || firstName.equals(study.getLastName())
                && lastName.equals(study.getFirstName())){
            return study;
        }
       throw new StudentExistException("Student does not exist");

    }
}
