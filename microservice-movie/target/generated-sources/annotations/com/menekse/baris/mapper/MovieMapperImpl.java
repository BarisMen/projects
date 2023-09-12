package com.menekse.baris.mapper;

import com.menekse.baris.dto.MovieDTO;
import com.menekse.baris.entity.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-12T17:17:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class MovieMapperImpl implements MovieMapper {

    private final ActorInfoMapper actorInfoMapper = ActorInfoMapper.INSTANCE;

    @Override
    public Movie dtoToEntity(MovieDTO movieDTO) {
        if ( movieDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setId( movieDTO.getId() );
        movie.setMovieName( movieDTO.getMovieName() );
        movie.setDescription( movieDTO.getDescription() );
        movie.setProductionDate( movieDTO.getProductionDate() );
        movie.setDirector( movieDTO.getDirector() );
        movie.setWriters( movieDTO.getWriters() );
        movie.setBudget( movieDTO.getBudget() );
        movie.setTrainerUrls( movieDTO.getTrainerUrls() );
        movie.setPosterUrls( movieDTO.getPosterUrls() );
        movie.setImageUrls( movieDTO.getImageUrls() );
        movie.setCreatedCompanyInfo( movieDTO.getCreatedCompanyInfo() );
        movie.setActorInfos( actorInfoMapper.dtoToEntities( movieDTO.getActorInfos() ) );

        return movie;
    }

    @Override
    public MovieDTO entityToDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setId( movie.getId() );
        movieDTO.setMovieName( movie.getMovieName() );
        movieDTO.setDescription( movie.getDescription() );
        movieDTO.setProductionDate( movie.getProductionDate() );
        movieDTO.setDirector( movie.getDirector() );
        movieDTO.setWriters( movie.getWriters() );
        movieDTO.setBudget( movie.getBudget() );
        movieDTO.setTrainerUrls( movie.getTrainerUrls() );
        movieDTO.setPosterUrls( movie.getPosterUrls() );
        movieDTO.setImageUrls( movie.getImageUrls() );
        movieDTO.setCreatedCompanyInfo( movie.getCreatedCompanyInfo() );
        movieDTO.setActorInfos( actorInfoMapper.entityToDto( movie.getActorInfos() ) );

        return movieDTO;
    }

    @Override
    public List<MovieDTO> entityToDto(List<Movie> movies) {
        if ( movies == null ) {
            return null;
        }

        List<MovieDTO> list = new ArrayList<MovieDTO>( movies.size() );
        for ( Movie movie : movies ) {
            list.add( entityToDto( movie ) );
        }

        return list;
    }

    @Override
    public List<Movie> dtoToEntities(List<MovieDTO> movieDTOS) {
        if ( movieDTOS == null ) {
            return null;
        }

        List<Movie> list = new ArrayList<Movie>( movieDTOS.size() );
        for ( MovieDTO movieDTO : movieDTOS ) {
            list.add( dtoToEntity( movieDTO ) );
        }

        return list;
    }
}
