package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.constant.Constants;
import com.arjuncodes.studentsystem.model.Address;
import com.arjuncodes.studentsystem.model.Student;
import com.arjuncodes.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(Constants.ADD_ENDPOINT)
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }

    @PutMapping("/update")
    public String update(@RequestBody Student student, Address address) {
        studentService.updateStudent(student);

        return "Updated Successfully";
    }

    @GetMapping(Constants.FIND_ALL_ENDPOINT)
    public List<Student> list() {
        studentService.findAllStudents();
        List<Student> response;
        response = studentService.findAllStudents();
        return response;


    }

    @GetMapping("/find/{id}")
    public Optional<Student> findById(@PathVariable("id") Integer id) {

        return studentService.findById(id);
    }

    @GetMapping("/{name}")
    @Query(value = "SELECT * FROM student WHERE name = :studentName", nativeQuery = true)
    public List<Student> findStudentByName(@PathVariable("name") String studentName) {
        studentService.findByName(studentName);

        return studentService.findByName(studentName);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return "Student has been deleted!";
    }
}
