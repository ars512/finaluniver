package com.example.demo.dto;


import com.example.demo.models.Group;
import com.example.demo.models.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String dtoName;
    private int age;
    private String email;
    private String password;
    private Group group;
    private Set<Subject> subjects;
}
