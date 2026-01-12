package com.example.demo.service.impl;

import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAll(){return studentMapper.toDtoList(studentRepository.findAll());}

    @Override
    public StudentDto getById(Long id){
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElse(null);
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto){
        Student student = studentMapper.toEntity(studentDto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDto(savedStudent);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto){
        if(!studentRepository.existsById(id)){
            return null;
        }

        Student student = studentMapper.toEntity(studentDto);
        student.setId(id);
        student.setName(studentDto.getDtoName());
        student.setAge(studentDto.getAge());
        student.setEmail(studentDto.getEmail());
        student.setPassword(studentDto.getPassword());
        student.setGroup(studentDto.getGroup());
        student.setSubjects(studentDto.getSubjects());

        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toDto(updatedStudent);
    }

    @Override
    public boolean deleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
