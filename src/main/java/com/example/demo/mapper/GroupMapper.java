package com.example.demo.mapper;

import com.example.demo.dto.GroupDto;
import com.example.demo.models.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    @Mapping(target = "dtoName",source = "name")
    GroupDto toDto(Group group);

    @Mapping(target = "name",source = "dtoName")
    Group toEntity(GroupDto groupDto);

    List<GroupDto> toDtoList(List<Group> groupList);
}
