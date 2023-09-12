package com.menekse.baris.mapper;

import com.menekse.baris.dto.ActorDTO;
import com.menekse.baris.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = MovieInfoMapper.class)
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);
    ActorDTO entityToDTO(Actor actor);
    Actor dtoToEntitiy(ActorDTO actorDTO);
    List<ActorDTO> entitiesToDTOs(List<Actor> actor);
    List<ActorDTO> dtoToEntities(List<ActorDTO> actorDTOS);
}

