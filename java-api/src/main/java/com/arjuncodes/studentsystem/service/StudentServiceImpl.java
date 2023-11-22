package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Address;
import com.arjuncodes.studentsystem.model.Student;
import com.arjuncodes.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();

    }

    @Override
    public void deleteStudent(Integer student_Id) {

        studentRepository.deleteById(student_Id);

    }

    @Override
    public Optional<Student> findById(Integer student_Id) {
        return studentRepository.findById(student_Id);
    }

    @Override
    public List<Student> findByName(String studentName) {
        return studentRepository.findAllByName(studentName);
    }

    @Override
    public void updateStudent(Student student) {
        Student update_student = studentRepository.findById(student.getId()).orElse(null);
        assert update_student != null;
        update_student.setName(student.getName());
        update_student.setAge(student.getAge());
        update_student.setAddress(student.getAddress());
        update_student.setContact(student.getContact());

        studentRepository.save(update_student);
    }

}
