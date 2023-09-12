package com.menekse.baris.mapper;

import com.menekse.baris.dto.MovieDTO;
import com.menekse.baris.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ActorInfoMapper.class)
public interface MovieMapper {
    MovieMapper INSTANCE=Mappers.getMapper(MovieMapper.class);
    Movie dtoToEntity(MovieDTO movieDTO);

    MovieDTO entityToDto(Movie movie);

    List<MovieDTO> entityToDto(List<Movie> movies);

    List<Movie> dtoToEntities(List<MovieDTO> movieDTOS);
}
