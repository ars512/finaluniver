package com.example.demo;

import com.example.demo.dto.SubjectDto;
import com.example.demo.mapper.SubjectMapper;
import com.example.demo.models.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubjectMapperTest {
    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    void convertEntityToDtoTest(){
        Subject subject = new Subject(1L,"MATH","Mathematics");
        SubjectDto subjectDto = subjectMapper.toDto(subject);

        Assertions.assertNotNull(subjectDto);
        Assertions.assertEquals(subject.getId(), subjectDto.getId());
        Assertions.assertEquals(subject.getCode(), subjectDto.getDtoCode());
        Assertions.assertEquals(subject.getName(), subjectDto.getName());
    }

    @Test
    void convertDtoToEntityTest(){
        SubjectDto subjectDto = new SubjectDto(2L,"PHYS","Physics");

        Subject subject = subjectMapper.toEntity(subjectDto);

        Assertions.assertNotNull(subject);
        Assertions.assertEquals(subjectDto.getId(), subject.getId());
        Assertions.assertEquals(subjectDto.getDtoCode(), subject.getCode());
        Assertions.assertEquals(subjectDto.getName(), subject.getName());
    }
}
