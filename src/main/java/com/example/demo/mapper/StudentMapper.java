package com.example.demo.mapper;


import com.example.demo.dto.StudentDto;
import com.example.demo.models.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "dtoName",source = "name")
    StudentDto toDto(Student student);

    @Mapping(target = "name",source = "dtoName")
    Student toEntity(StudentDto studentDto);

    List<StudentDto> toDtoList(List<Student> studentList);
}
