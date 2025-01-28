package com.jpahibernatexample.student_management.service;

import com.jpahibernatexample.student_management.model.Student;
import com.jpahibernatexample.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service // it is service layer and contains business logic
public class StudentService {

    @Autowired // it creates an spring internal bean
    private StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "Student saved successfully";
    }

    public Student findStudentById(int studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isPresent()){
          return studentOptional.get();
        }
        return null;
    }

    public List<Student> findAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public String countStudents(){
        long totalcount = studentRepository.count();
        return "Total count of students are : " +totalcount;
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student with id : "+id +" git deleted";
    }

    // while using put - we have to send whole student object for updating operation
    public String updateStudentByPut(int id, Student newStudentRequest){
        //find the student by id
        //if the student is present then perform update operation
        //else cannot update
        Student oldStudent = findStudentById(id);
        if(oldStudent!=null){
            studentRepository.save(newStudentRequest);
            return "Student updated successfully";
        }else{
            return "Student not found and Cannot perform update operation";
        }
    }

    // while using patch - we have to send only specific fields which are required for updating operation
    public String updateStudentByPatch(int id, String mobile){
        //find the student by id
        //if the student is present then perform update operation
        //else cannot update
        Student oldStudent = findStudentById(id);
        if(oldStudent!=null){
            oldStudent.setMobile(mobile);
            studentRepository.save(oldStudent);
            return "Student updated successfully";
        } else{
            return "Student not found and not updated ";
        }
    }

}
