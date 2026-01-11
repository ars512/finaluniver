package com.example.demo.service;

import com.example.demo.dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> getAll();
    SubjectDto getById(Long id);
    SubjectDto addSubject(SubjectDto subjectDto);
    SubjectDto updateSubject(Long id, SubjectDto subjectDto);
    boolean deleteSubject(Long id);
}
