package com.example.demo;

import com.example.demo.dto.GroupDto;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.models.Group;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GroupMapperTest {
    @Autowired
    private GroupMapper groupMapper;
    @Test
    void convertEntityToDtoTest() {
        Group group = new Group();
        group.setId(1L);
        group.setName("CS-101");
        GroupDto groupDto = groupMapper.toDto(group);

        Assertions.assertNotNull(groupDto);
        Assertions.assertEquals(group.getId(), groupDto.getId());
        Assertions.assertEquals(group.getName(), groupDto.getDtoName());
    }
    @Test
    void convertDtoToEntityTest() {
        GroupDto groupDto = new GroupDto(2l,"FN-102");
        Group group = groupMapper.toEntity(groupDto);

        Assertions.assertNotNull(group);
        Assertions.assertEquals(groupDto.getId(), group.getId());
        Assertions.assertEquals(groupDto.getDtoName(), group.getName());
    }
}
