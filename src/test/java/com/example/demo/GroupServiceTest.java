package com.example.demo;

import com.example.demo.dto.GroupDto;
import com.example.demo.service.GroupService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class GroupServiceTest {
    @Autowired
    private GroupService groupService;

    @Test
    void getAllTest(){
        List<GroupDto> list = groupService.getAll();
        Assertions.assertNotNull(list);
        Assertions.assertNotEquals(0, list.size());
        for(GroupDto groupDto : list){
            Assertions.assertNotNull(groupDto);
            Assertions.assertNotNull(groupDto.getId());
            Assertions.assertNotNull(groupDto.getDtoName());
        }
    }
    @Test
    void getByIdTest(){
        List<GroupDto> list = groupService.getAll();
        if(list.isEmpty()) return;
        Random random = new Random();
        Long id = list.get(random.nextInt(list.size())).getId();
        GroupDto groupDto = groupService.getById(id);
        Assertions.assertNotNull(groupDto);
        Assertions.assertEquals(id, groupDto.getId());
    }

    @Test
    void addGroupTest(){
        GroupDto groupDto = new GroupDto();
        groupDto.setDtoName("test");
        GroupDto created= groupService.addGroup(groupDto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(groupDto.getDtoName(), created.getDtoName());
        GroupDto found = groupService.getById(created.getId());
        Assertions.assertEquals(found.getDtoName(), created.getDtoName());
    }

    @Test
    void updateGroupTest(){
        GroupDto groupDto = new GroupDto();
        groupDto.setDtoName("test");
        GroupDto created= groupService.addGroup(groupDto);
        GroupDto update= new GroupDto();
        update.setDtoName("updated");
        GroupDto updated = groupService.updateGroup(created.getId(), update);
        Assertions.assertNotNull(updated);
        Assertions.assertEquals("updated", updated.getDtoName());
        GroupDto found = groupService.getById(created.getId());
        Assertions.assertEquals("updated", found.getDtoName());
    }

    @Test
    void deleteGroupTest(){
        GroupDto groupDto = new GroupDto();
        groupDto.setDtoName("test");
        GroupDto created= groupService.addGroup(groupDto);

        Long id = created.getId();
        Assertions.assertNotNull(id);

        boolean deleted = groupService.deleteGroup(id);
        Assertions.assertTrue(deleted);
        Assertions.assertThrows(
                RuntimeException.class,
                () -> groupService.getById(id)
        );
    }
}
