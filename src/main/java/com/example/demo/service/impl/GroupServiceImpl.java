package com.example.demo.service.impl;

import com.example.demo.dto.GroupDto;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.models.Group;
import com.example.demo.repository.GroupRepository;
import com.example.demo.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupMapper groupMapper;
    private final GroupRepository groupRepository;

    @Override
    public List<GroupDto> getAll(){return groupMapper.toDtoList(groupRepository.findAll());}

    @Override
    public GroupDto getById(Long id){
        return groupMapper.toDto(groupRepository.findById(id).orElseThrow());
    }

    @Override
    public GroupDto addGroup(GroupDto groupDto){
        Group group = groupMapper.toEntity(groupDto);
        Group saved = groupRepository.save(group);
        return groupMapper.toDto(saved);
    }
    @Override
    public GroupDto updateGroup(Long id, GroupDto groupDto){
        Group group = groupMapper.toEntity(groupDto);
        group.setId(id);
        group.setName(groupDto.getDtoName());
        Group updated = groupRepository.save(group);
        return groupMapper.toDto(updated);
    }

    @Override
    public boolean deleteGroup(Long id){
        if(!groupRepository.existsById(id)){
            return false;
        }
        groupRepository.deleteById(id);
        return true;
    }
}
