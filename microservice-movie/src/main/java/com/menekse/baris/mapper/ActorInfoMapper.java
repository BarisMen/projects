package com.menekse.baris.mapper;

import com.menekse.baris.dto.ActorInfoDTO;
import com.menekse.baris.entity.ActorInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ActorInfoMapper {
    ActorInfoMapper INSTANCE= Mappers.getMapper(ActorInfoMapper.class);
    @Mappings({
            @Mapping(target = "movie",ignore = true),
    })
    ActorInfo dtoToEntity(ActorInfoDTO actorInfoDTO);

    ActorInfoDTO entityToDto(ActorInfo actorInfo);

    List<ActorInfoDTO> entityToDto(List<ActorInfo> actorInfos);

    List<ActorInfo> dtoToEntities(List<ActorInfoDTO> actorInfoDtos);
}
