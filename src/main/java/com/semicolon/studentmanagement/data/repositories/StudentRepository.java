package com.semicolon.studentmanagement.data.repositories;

import com.semicolon.studentmanagement.data.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}