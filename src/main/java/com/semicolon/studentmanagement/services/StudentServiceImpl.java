package com.semicolon.studentmanagement.services;
import com.semicolon.studentmanagement.Mapper;
import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.data.repositories.StudentRepository;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.DeleteStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.UpdateResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;
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
        studentId ="ST"+ studentId.substring(1, 4);

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
    public DeleteStudentResponse delete(String request) {
        Optional<Student> exist = studentRepository.findById(Integer.valueOf(request));
        if(exist.isEmpty()){
            throw new StudentExistException("student does not exist");
        }
        else {
            studentRepository.deleteById(Integer.valueOf(request));
            DeleteStudentResponse response = new DeleteStudentResponse();
            response.setMessage("Deletion successful");
            return response;
        }
    }

    @Override @Transactional
    public UpdateResponse updateStudent(String id, String name, String email) {
        Student student = studentRepository.findById(Integer.valueOf(id)).
                orElseThrow(() -> new StudentExistException("student with id "+ id + "does not exist"));
        UpdateResponse response = new UpdateResponse();


        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
            response.setMessage("updated "+ student.getName());
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){

            Optional<Student> student1 = studentRepository.findByEmail(email);
            if(student1.isPresent()){
                throw new StudentExistException("email taken");
            }
            student.setEmail(email);
            response.setMessage("updated "+ student.getName());
        }

        return response;
    }

    @Override
    public Student findStudentByName(String name) {
        Optional<Student> student = studentRepository.findStudentByName(name);
        if(student.isPresent()){
            if(student.get().getName().equalsIgnoreCase(name)){
                return student.get();
            }else {
                throw new StudentExistException("student not found");
            }

        }else {
            throw new StudentExistException("student does not exist");
        }

    }
}
