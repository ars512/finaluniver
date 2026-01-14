package com.example.demo;

import com.example.demo.dto.StudentDto;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.models.Student;
import com.example.demo.models.Permission;
import com.example.demo.models.Group;
import com.example.demo.models.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;


@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    void convertEntityToDtoTest() {
        Group group = new Group();
        group.setId(1L);
        group.setName("CS-101");

        Subject subject1 = new Subject(1L, "Mathematics", "MATH");
        Subject subject2 = new Subject(2L, "Physics", "PHYSICS");
        Set<Subject> subjects = Set.of(subject1, subject2);
        Permission permission1= new Permission(1L,"USER");
        Permission permission2= new Permission(2L,"ADMIN");
        List<Permission> permissionList= List.of(permission1,permission2);

        Student student = new Student(1L,"Dan",20,"dan@gmail.com","123","USER", group,subjects,permissionList);
        StudentDto studentDto = studentMapper.toDto(student);

        Assertions.assertNotNull(studentDto);
        Assertions.assertNotNull(studentDto.getId());
        Assertions.assertNotNull(studentDto.getDtoName());
        Assertions.assertNotNull(studentDto.getAge());
        Assertions.assertNotNull(studentDto.getEmail());
        Assertions.assertNotNull(studentDto.getPassword());
        Assertions.assertNotNull(studentDto.getGroup());
        Assertions.assertNotNull(studentDto.getSubjects());

        Assertions.assertEquals(student.getId(), studentDto.getId());
        Assertions.assertEquals(student.getName(), studentDto.getDtoName());
        Assertions.assertEquals(student.getAge(), studentDto.getAge());
        Assertions.assertEquals(student.getEmail(), studentDto.getEmail());
        Assertions.assertEquals(student.getPassword(), studentDto.getPassword());
        Assertions.assertEquals(student.getGroup(), studentDto.getGroup());
        Assertions.assertEquals(student.getSubjects(), studentDto.getSubjects());
    }

    @Test
    void convertDtoToEntityTest() {
        Group group = new Group();
        group.setId(1L);
        group.setName("CS-102");

        Subject subject1 = new Subject(1L, "Algorithms", "ALGO");
        Subject subject2 = new Subject(2L, "Databases", "DB");
        Set<Subject>subjects = Set.of(subject1, subject2);

        StudentDto studentDto = new StudentDto(1L,"Dan",21,"dan@gmail.com","123", group,subjects);
        Student student = studentMapper.toEntity(studentDto);

        Assertions.assertNotNull(student);
        Assertions.assertNotNull(student.getId());
        Assertions.assertNotNull(student.getName());
        Assertions.assertNotNull(student.getAge());
        Assertions.assertNotNull(student.getEmail());
        Assertions.assertNotNull(student.getPassword());
        Assertions.assertNotNull(student.getGroup());
        Assertions.assertNotNull(student.getSubjects());

        Assertions.assertEquals(student.getId(), studentDto.getId());
        Assertions.assertEquals(student.getName(), studentDto.getDtoName());
        Assertions.assertEquals(student.getAge(), studentDto.getAge());
        Assertions.assertEquals(student.getEmail(), studentDto.getEmail());
        Assertions.assertEquals(student.getPassword(), studentDto.getPassword());
        Assertions.assertEquals(student.getGroup(), studentDto.getGroup());
        Assertions.assertEquals(student.getSubjects(), studentDto.getSubjects());
    }
}
