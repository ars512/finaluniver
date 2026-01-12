package com.example.demo.service.impl;

import com.example.demo.dto.SubjectDto;
import com.example.demo.mapper.SubjectMapper;
import com.example.demo.models.Subject;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectMapper subjectMapper;
    private final SubjectRepository subjectRepository;

    @Override
    public List<SubjectDto> getAll() {
        return subjectMapper.toDtoList(subjectRepository.findAll());
    }

    @Override
    public SubjectDto getById(Long id) {
        return subjectMapper.toDto(subjectRepository.findById(id).orElseThrow());
    }

    @Override
    public SubjectDto addSubject(SubjectDto subjectDto) {
        Subject subject = subjectMapper.toEntity(subjectDto);
        Subject saved = subjectRepository.save(subject);
        return subjectMapper.toDto(saved);
    }

    @Override
    public SubjectDto updateSubject(Long id, SubjectDto subjectDto) {
        Subject subject = subjectMapper.toEntity(subjectDto);
        subject.setId(id);
        subject.setCode(subjectDto.getDtoCode());
        subject.setName(subjectDto.getName());
        Subject updated = subjectRepository.save(subject);
        return subjectMapper.toDto(updated);
    }
    @Override
    public boolean deleteSubject(Long id) {
        if(!subjectRepository.existsById(id)) {
            return false;
        }
        subjectRepository.deleteById(id);
        return true;
    }
}
