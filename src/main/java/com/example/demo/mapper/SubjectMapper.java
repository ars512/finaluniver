package com.example.demo.mapper;

import com.example.demo.dto.SubjectDto;
import com.example.demo.models.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    @Mapping(target = "dtoCode",source = "code")
    SubjectDto toDto(Subject subject);

    @Mapping(target = "code",source = "dtoCode")
    Subject toEntity(SubjectDto subjectDto);

    List<SubjectDto> toDtoList(List<Subject> subjectList);
}
