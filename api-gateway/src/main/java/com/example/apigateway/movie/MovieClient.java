package com.example.apigateway.movie;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MovieClient {

    public List<MovieDTO> getMovies(MovieQueryDTO movieQueryDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Set the correct content type

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<MovieDTO>> responseEntity = restTemplate.exchange(
                "http://localhost:9999/movies/query",
                HttpMethod.POST,
                new HttpEntity<>(movieQueryDTO, headers),
                new ParameterizedTypeReference<List<MovieDTO>>() {
                }
        );
        return responseEntity.getBody();
    }


}
