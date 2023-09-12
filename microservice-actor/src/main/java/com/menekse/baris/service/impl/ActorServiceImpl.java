package com.menekse.baris.service.impl;

import com.menekse.baris.dto.QueryDTO;
import com.menekse.baris.entity.Actor;
import com.menekse.baris.entity.MovieInfo;
import com.menekse.baris.repository.ActorRepository;
import com.menekse.baris.service.ActorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.menekse.baris.repository.ActorSpecification.*;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;


    @Override
    public Actor add(Actor actor) {
        List<MovieInfo> movieInfoList = new ArrayList<>();
        movieInfoList.addAll(actor.getMovieInfos());
        actor.clearList();
        for (MovieInfo movieInfo : movieInfoList) {
            actor.addListMovieInfo(movieInfo);
        }
        Actor actor1 = actorRepository.save(actor);
        return actor1;

    }

    @Override
    public List<Actor> getActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor updateById(Long id, Actor actor) {
        Actor resultActor = actorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie is not found!"));
        resultActor.setName(actor.getName());
        resultActor.setBirthDate(actor.getBirthDate());
        resultActor.setMovieInfos(actor.getMovieInfos());
        resultActor.setHeight(actor.getHeight());
        resultActor.setImages(actor.getImages());
        resultActor.setPersonalSummary(actor.getPersonalSummary());
        return actorRepository.save(resultActor);
    }

    @Override
    public Actor getActor(Long id) {
        return actorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie is not found!"));
    }

    @Override
    public List<Actor> getActorsFromQuery(QueryDTO queryDTO) {

        Specification<Actor> spec = null;

        if (!CollectionUtils.isEmpty(queryDTO.getMovieIds())) {
            hasJoinMovieInfo(queryDTO.getMovieIds()).and(spec);
        }
        if (StringUtils.hasLength(queryDTO.getRoledMovies())) {
            spec = hasJoinMovieInfoLike("roledMovies", queryDTO.getRoledMovies()).and(spec);
        }
        if (StringUtils.hasLength(queryDTO.getRoledCharacter())) {
            spec = hasJoinMovieInfoLike("roledCharacter", queryDTO.getRoledCharacter()).and(spec);
        }

        if (StringUtils.hasLength(queryDTO.getName())) {
            spec = hasFieldLike("name", queryDTO.getName()).and(spec);
        }
        /*if (StringUtils.hasLength(queryDTO.getBirthDate())) {
            spec = hasFieldLike("birthDate", queryDTO.getBirthDate()).and(spec);
        }*/
        if (queryDTO.getHeight() != null && queryDTO.getHeight().intValue() > 0) {
            spec = hasFieldEqualInteger("height", queryDTO.getHeight().intValue()).and(spec);
        }


        if (StringUtils.hasLength(queryDTO.getPersonalSummary())) {
            spec = hasFieldLike("personalSummary", queryDTO.getPersonalSummary()).and(spec);
        }
        if (StringUtils.hasLength(queryDTO.getImages())) {
            spec = hasFieldLike("images", queryDTO.getImages()).and(spec);
        }



        if (spec != null) {
            return actorRepository.findAll(spec);
        } else {
            return actorRepository.findAll();
        }

    }
}
