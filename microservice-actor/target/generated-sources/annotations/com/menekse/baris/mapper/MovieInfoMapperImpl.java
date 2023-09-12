package com.menekse.baris.mapper;

import com.menekse.baris.dto.MovieInfoDTO;
import com.menekse.baris.entity.MovieInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-12T17:17:31+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class MovieInfoMapperImpl implements MovieInfoMapper {

    @Override
    public MovieInfoDTO entityToDTO(MovieInfo movieInfo) {
        if ( movieInfo == null ) {
            return null;
        }

        MovieInfoDTO movieInfoDTO = new MovieInfoDTO();

        movieInfoDTO.setId( movieInfo.getId() );
        movieInfoDTO.setMovieID( movieInfo.getMovieID() );
        movieInfoDTO.setRoledMovies( movieInfo.getRoledMovies() );
        movieInfoDTO.setRoledCharacter( movieInfo.getRoledCharacter() );

        return movieInfoDTO;
    }

    @Override
    public List<MovieInfoDTO> entitiesToDTOs(List<MovieInfo> movieInfos) {
        if ( movieInfos == null ) {
            return null;
        }

        List<MovieInfoDTO> list = new ArrayList<MovieInfoDTO>( movieInfos.size() );
        for ( MovieInfo movieInfo : movieInfos ) {
            list.add( entityToDTO( movieInfo ) );
        }

        return list;
    }
}
