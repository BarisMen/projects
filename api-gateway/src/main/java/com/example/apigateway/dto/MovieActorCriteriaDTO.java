package com.example.apigateway.dto;

import com.example.apigateway.actor.ActorQueryDTO;
import com.example.apigateway.movie.MovieQueryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieActorCriteriaDTO {
    // MovieDto
    private MovieQueryDTO movieQueryDTO;
    // ActorDto
    private ActorQueryDTO actorQueryDTO;

}
