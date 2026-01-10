package com.example.demo.service;

import com.example.demo.dto.AddStudentDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> modelMapper.map(student,StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudnetById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student not found"));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createStudent(AddStudentDto addStudentDto) {
       Student student = modelMapper.map(addStudentDto,Student.class);
        Student save = studentRepository.save(student);
        return modelMapper.map(save,StudentDto.class);
    }

    @Override
    public void deleteById(Long id) {
        if (!studentRepository.existsById(id)){
            throw new IllegalArgumentException("student does not exist by id"+id);
        }
        studentRepository.deleteById(id);
    }
}
