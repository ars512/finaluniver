package com.example.demo.service;

import com.example.demo.dto.GroupDto;

import java.util.List;

public interface GroupService {
    List<GroupDto> getAll();
    GroupDto getById(Long id);
    GroupDto addGroup(GroupDto groupDto);
    GroupDto updateGroup(Long id, GroupDto groupDto);
    boolean deleteGroup(Long id);
}
