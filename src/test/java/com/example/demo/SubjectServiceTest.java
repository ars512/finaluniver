package com.example.demo;

import com.example.demo.dto.SubjectDto;
import com.example.demo.service.SubjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class SubjectServiceTest {
    @Autowired
    private SubjectService subjectService;

    @Test
    void getAllTest(){
        List<SubjectDto> list = subjectService.getAll();
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
        for(SubjectDto subjectDto : list){
            Assertions.assertNotNull(subjectDto);
            Assertions.assertNotNull(subjectDto.getId());
            Assertions.assertNotNull(subjectDto.getName());
            Assertions.assertNotNull(subjectDto.getDtoCode());
        }
    }
    @Test
    void getByIdTest(){
        List<SubjectDto> all = subjectService.getAll();
        if(all.isEmpty()) return;
        Random random = new Random();
        Long id = all.get(random.nextInt(all.size())).getId();

        SubjectDto subjectDto = subjectService.getById(id);
        Assertions.assertNotNull(subjectDto);
        Assertions.assertEquals(id, subjectDto.getId());
    }

    @Test
    void addSubjectTest(){
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setDtoCode("MATH");
        subjectDto.setName("Mathematics");

        SubjectDto created = subjectService.addSubject(subjectDto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(subjectDto.getName(), created.getName());
        Assertions.assertEquals(subjectDto.getDtoCode(), created.getDtoCode());

        SubjectDto found = subjectService.getById(created.getId());
        Assertions.assertEquals(found.getName(), created.getName());
    }
    @Test
    void updateSubjectTest(){
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setDtoCode("MATH");
        subjectDto.setName("Mathematics");

        SubjectDto created = subjectService.addSubject(subjectDto);
        SubjectDto update = new SubjectDto();
        update.setDtoCode("PHYS");
        update.setName("Physics");

        SubjectDto updated = subjectService.updateSubject(created.getId(), update);
        Assertions.assertNotNull(updated);
        Assertions.assertEquals("PHYS",updated.getDtoCode());
        Assertions.assertEquals("Physics",updated.getName());
        SubjectDto found = subjectService.getById(created.getId());
        Assertions.assertEquals(found.getName(), "Physics");
    }

    @Test
    void deleteSubjectTest(){
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setDtoCode("MATH");
        subjectDto.setName("Mathematics");
        SubjectDto created= subjectService.addSubject(subjectDto);
        Long id = created.getId();
        Assertions.assertNotNull(id);
        boolean deleted = subjectService.deleteSubject(id);
        Assertions.assertTrue(deleted);
        Assertions.assertThrows(
                RuntimeException.class,
                () -> subjectService.getById(id)
        );
    }
}
