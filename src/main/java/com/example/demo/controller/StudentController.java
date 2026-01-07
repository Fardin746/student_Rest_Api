package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto studentDto(){
        return new StudentDto(1L,"Fardin","fardeen@gmail.com");
    }
}
