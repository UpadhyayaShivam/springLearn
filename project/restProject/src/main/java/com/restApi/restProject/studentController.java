package com.restApi.restProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class studentController {
    @Autowired
    private studentRepo studentRepository;

    @GetMapping("/students")
    public List<studentEntity> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public studentEntity retrieveStudent(@PathVariable long id) {
        Optional<studentEntity> student = studentRepository.findById(id);

        if (student.isEmpty())
            System.out.println("not found");

        return student.get();
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
    }

}
