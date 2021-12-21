package com.uniongraphix.userspringsystem.controller;

import com.uniongraphix.userspringsystem.model.Student;
import com.uniongraphix.userspringsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    // 서버에 저장(서버에 넘겨주는 부분)
    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New Student id added.";
    }

    // 서버에서 데이터 읽어오기(프론트에 넘겨주는 부분)
    @GetMapping("/getAll")
    public List<Student> list() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{id}")
    public Optional<Student> getStudent(@PathVariable("id") int id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/delStudent/{id}")
    public void delStudent(@PathVariable("id") int id) {
        studentService.delStudent(id);
    }
}
