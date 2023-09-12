package com.example.apigateway.actor;

import com.example.apigateway.movie.MovieDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
//@RequiredArgsConstructor
public class ActorClient {


    public List<ActorDTO> getActors(ActorQueryDTO actorQueryDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Set the correct content type

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ActorDTO>> responseEntity = restTemplate.exchange(
                "http://localhost:9998/actors/query",
                HttpMethod.POST,
                new HttpEntity<>(actorQueryDTO, headers),
                new ParameterizedTypeReference<List<ActorDTO>>() {
                }
        );
        return responseEntity.getBody();

    }


}
