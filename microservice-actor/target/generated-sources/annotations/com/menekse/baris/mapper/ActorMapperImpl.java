package com.menekse.baris.mapper;

import com.menekse.baris.dto.ActorDTO;
import com.menekse.baris.dto.MovieInfoDTO;
import com.menekse.baris.entity.Actor;
import com.menekse.baris.entity.MovieInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-12T17:17:31+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
public class ActorMapperImpl implements ActorMapper {

    private final MovieInfoMapper movieInfoMapper = MovieInfoMapper.INSTANCE;

    @Override
    public ActorDTO entityToDTO(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorDTO actorDTO = new ActorDTO();

        actorDTO.setId( actor.getId() );
        actorDTO.setName( actor.getName() );
        actorDTO.setBirthDate( actor.getBirthDate() );
        actorDTO.setHeight( actor.getHeight() );
        actorDTO.setPersonalSummary( actor.getPersonalSummary() );
        actorDTO.setImages( actor.getImages() );
        actorDTO.setMovieInfos( movieInfoMapper.entitiesToDTOs( actor.getMovieInfos() ) );

        return actorDTO;
    }

    @Override
    public Actor dtoToEntitiy(ActorDTO actorDTO) {
        if ( actorDTO == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setId( actorDTO.getId() );
        actor.setName( actorDTO.getName() );
        actor.setBirthDate( actorDTO.getBirthDate() );
        actor.setHeight( actorDTO.getHeight() );
        actor.setPersonalSummary( actorDTO.getPersonalSummary() );
        actor.setImages( actorDTO.getImages() );
        actor.setMovieInfos( movieInfoDTOListToMovieInfoList( actorDTO.getMovieInfos() ) );

        return actor;
    }

    @Override
    public List<ActorDTO> entitiesToDTOs(List<Actor> actor) {
        if ( actor == null ) {
            return null;
        }

        List<ActorDTO> list = new ArrayList<ActorDTO>( actor.size() );
        for ( Actor actor1 : actor ) {
            list.add( entityToDTO( actor1 ) );
        }

        return list;
    }

    @Override
    public List<ActorDTO> dtoToEntities(List<ActorDTO> actorDTOS) {
        if ( actorDTOS == null ) {
            return null;
        }

        List<ActorDTO> list = new ArrayList<ActorDTO>( actorDTOS.size() );
        for ( ActorDTO actorDTO : actorDTOS ) {
            list.add( actorDTO );
        }

        return list;
    }

    protected MovieInfo movieInfoDTOToMovieInfo(MovieInfoDTO movieInfoDTO) {
        if ( movieInfoDTO == null ) {
            return null;
        }

        MovieInfo movieInfo = new MovieInfo();

        movieInfo.setId( movieInfoDTO.getId() );
        movieInfo.setMovieID( movieInfoDTO.getMovieID() );
        movieInfo.setRoledMovies( movieInfoDTO.getRoledMovies() );
        movieInfo.setRoledCharacter( movieInfoDTO.getRoledCharacter() );

        return movieInfo;
    }

    protected List<MovieInfo> movieInfoDTOListToMovieInfoList(List<MovieInfoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<MovieInfo> list1 = new ArrayList<MovieInfo>( list.size() );
        for ( MovieInfoDTO movieInfoDTO : list ) {
            list1.add( movieInfoDTOToMovieInfo( movieInfoDTO ) );
        }

        return list1;
    }
}
