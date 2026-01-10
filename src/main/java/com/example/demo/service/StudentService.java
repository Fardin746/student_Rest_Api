package com.example.demo.service;

import com.example.demo.dto.AddStudentDto;
import com.example.demo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDto> getAllStudent();

    StudentDto getStudnetById(Long id);
    StudentDto createStudent(AddStudentDto addStudentDto);

    void deleteById(Long id);
}
