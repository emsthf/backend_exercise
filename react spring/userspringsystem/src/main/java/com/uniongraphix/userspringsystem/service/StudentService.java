package com.uniongraphix.userspringsystem.service;

import com.uniongraphix.userspringsystem.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    Optional<Student> getStudent(int id);
    void delStudent(int id);
    public List<Student> getAllStudents();
}
