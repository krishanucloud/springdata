package com.springdata.springdata.controller;

import com.springdata.springdata.entity.Guide;
import com.springdata.springdata.entity.Student;
import com.springdata.springdata.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/create/{name}")
    public Student createStudent(@PathVariable("name") String name) {
        Student student = new Student();
        student.setName(name);
        Guide guide = new Guide();
        guide.setName("Guide1");
        student.setGuide(guide);
        return studentRepository.save(student);
    }

    @GetMapping("/retrieve-all")
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{name}")
    public Student fetchStudent(@PathVariable("name") String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.findByName(name);
    }
}
