package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Address;
import com.arjuncodes.studentsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public void saveStudent(Student student);
    public List<Student> findAllStudents();

    public void deleteStudent(Integer student_Id);


    public Optional<Student> findById(Integer student_Id);


    public List<Student> findByName(String name);

    public void updateStudent(Student student);


}
