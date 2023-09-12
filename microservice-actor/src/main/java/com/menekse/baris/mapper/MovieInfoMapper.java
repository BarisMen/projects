package com.menekse.baris.mapper;

import com.menekse.baris.dto.ActorDTO;
import com.menekse.baris.dto.MovieInfoDTO;
import com.menekse.baris.entity.Actor;
import com.menekse.baris.entity.MovieInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface MovieInfoMapper {

    MovieInfoMapper INSTANCE = Mappers.getMapper(MovieInfoMapper.class);
    MovieInfoDTO entityToDTO(MovieInfo movieInfo);
    List<MovieInfoDTO> entitiesToDTOs(List<MovieInfo> movieInfos);
}
