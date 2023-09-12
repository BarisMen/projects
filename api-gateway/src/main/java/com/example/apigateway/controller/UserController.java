package com.example.apigateway.controller;

import com.example.apigateway.actor.ActorClient;
import com.example.apigateway.actor.ActorDTO;
import com.example.apigateway.dto.MovieActorCriteriaDTO;
import com.example.apigateway.dto.MovieActorDTO;
import com.example.apigateway.movie.ActorInfoDTO;
import com.example.apigateway.movie.MovieClient;
import com.example.apigateway.movie.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/composition")
@RequiredArgsConstructor
public class UserController {
    private final MovieClient movieClient;
    private final ActorClient actorClient;

    @PostMapping("/query")
    public List<MovieActorDTO> movieActorDTO(@RequestBody  MovieActorCriteriaDTO movieActorCriteriaDTO) {

        List<MovieDTO> listMovieDTOS = movieClient.getMovies(movieActorCriteriaDTO.getMovieQueryDTO());
        List<ActorDTO> listActors = actorClient.getActors(movieActorCriteriaDTO.getActorQueryDTO());
        // Response Hazırlıyorum
        List<MovieActorDTO> response = new ArrayList<>();
        for (MovieDTO movieDTO : listMovieDTOS) {
            List<ActorInfoDTO> filteredActorInfos = movieDTO.getActorInfos()
                    .stream()
                    .filter(actorInfo -> listActors.stream().anyMatch(actor -> actorInfo.getActorId() == actor.getId()))
                    .collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(filteredActorInfos)) {
                MovieActorDTO movieActorDTO = new MovieActorDTO();
                movieActorDTO.setMovieName(movieDTO.getMovieName());
                movieActorDTO.setId(movieDTO.getId());
                movieActorDTO.setDescription(movieDTO.getDescription());
                movieActorDTO.setProductionDate(movieDTO.getProductionDate());
                movieActorDTO.setDirector(movieDTO.getDirector());
                movieActorDTO.setWriters(movieDTO.getWriters());
                movieActorDTO.setBudget(movieActorDTO.getBudget());
                movieActorDTO.setTrainerUrls(movieActorDTO.getTrainerUrls());
                movieActorDTO.setPosterUrls(movieActorDTO.getPosterUrls());
                movieActorDTO.setImageUrls(movieActorDTO.getImageUrls());
                movieActorDTO.setCreatedCompanyInfo(movieDTO.getCreatedCompanyInfo());
                for (ActorInfoDTO actorInfoDTO : filteredActorInfos) {
                    List<ActorDTO> actorDTOS = listActors.stream().filter(x -> x.getId() == actorInfoDTO.getActorId()).collect(Collectors.toList());
                    movieActorDTO.setActorDTOS(actorDTOS);
                }
                response.add(movieActorDTO);
            }
        }


        return response;
    }
}
