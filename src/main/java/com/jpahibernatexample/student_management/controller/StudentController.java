package com.jpahibernatexample.student_management.controller;

import com.jpahibernatexample.student_management.model.Student;
import com.jpahibernatexample.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return response;
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        Student response = studentService.findStudentById(id);
        return response;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        List<Student> studentList= studentService.findAllStudents();
        return studentList;
    }

    @GetMapping("/count")
    public String countStudents(){
        String response = studentService.countStudents();
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response = studentService.deleteStudentById(id);
        return response;
    }
}
