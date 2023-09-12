package com.menekse.baris.mapper;

import com.menekse.baris.dto.ActorInfoDTO;
import com.menekse.baris.entity.ActorInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-12T17:17:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class ActorInfoMapperImpl implements ActorInfoMapper {

    @Override
    public ActorInfo dtoToEntity(ActorInfoDTO actorInfoDTO) {
        if ( actorInfoDTO == null ) {
            return null;
        }

        ActorInfo actorInfo = new ActorInfo();

        actorInfo.setActorId( actorInfoDTO.getActorId() );
        actorInfo.setActors( actorInfoDTO.getActors() );
        actorInfo.setActorsAndRoles( actorInfoDTO.getActorsAndRoles() );

        return actorInfo;
    }

    @Override
    public ActorInfoDTO entityToDto(ActorInfo actorInfo) {
        if ( actorInfo == null ) {
            return null;
        }

        ActorInfoDTO actorInfoDTO = new ActorInfoDTO();

        actorInfoDTO.setActorId( actorInfo.getActorId() );
        actorInfoDTO.setActors( actorInfo.getActors() );
        actorInfoDTO.setActorsAndRoles( actorInfo.getActorsAndRoles() );

        return actorInfoDTO;
    }

    @Override
    public List<ActorInfoDTO> entityToDto(List<ActorInfo> actorInfos) {
        if ( actorInfos == null ) {
            return null;
        }

        List<ActorInfoDTO> list = new ArrayList<ActorInfoDTO>( actorInfos.size() );
        for ( ActorInfo actorInfo : actorInfos ) {
            list.add( entityToDto( actorInfo ) );
        }

        return list;
    }

    @Override
    public List<ActorInfo> dtoToEntities(List<ActorInfoDTO> actorInfoDtos) {
        if ( actorInfoDtos == null ) {
            return null;
        }

        List<ActorInfo> list = new ArrayList<ActorInfo>( actorInfoDtos.size() );
        for ( ActorInfoDTO actorInfoDTO : actorInfoDtos ) {
            list.add( dtoToEntity( actorInfoDTO ) );
        }

        return list;
    }
}
