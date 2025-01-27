package com.jpahibernatexample.student_management.repository;

import com.jpahibernatexample.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// class ->class - inheritance(extends)
// interface ->interface- inheritance(extends)
// interface-> class-implements(interface)


@Repository // it is a data layer and it performs database operations
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
