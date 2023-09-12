package com.menekse.baris.api;

import com.menekse.baris.dto.MovieDTO;
import com.menekse.baris.dto.MovieQueryDTO;
import com.menekse.baris.entity.Movie;
import com.menekse.baris.mapper.MovieMapper;
import com.menekse.baris.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/* DTO kullanıp servis katmanına indirirken Mapper kullanabilirdim Zaman sıkıntısından kullanmadım*/

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final HttpServletRequest request;

    @PostMapping
    public ResponseEntity<MovieDTO> add(@RequestBody MovieDTO movieDTO) {
        Movie resultMovie = movieService.add(MovieMapper.INSTANCE.dtoToEntity(movieDTO));
        return ResponseEntity.ok(MovieMapper.INSTANCE.entityToDto(resultMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAMovies() {
        System.out.println(request.getHeader("Authorization"));
        System.out.println(request);
        List<Movie> resultMovies = movieService.getMovies();
        return ResponseEntity.ok(MovieMapper.INSTANCE.entityToDto(resultMovies));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateById(@PathVariable("id") Long id, @RequestBody MovieDTO movieDTO) {
        Movie resultMovies = movieService.updateById(id, MovieMapper.INSTANCE.dtoToEntity(movieDTO));
        return ResponseEntity.ok(MovieMapper.INSTANCE.entityToDto(resultMovies));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable("id") Long id) {
        Movie resultMovie = movieService.getMovie(id);
        return ResponseEntity.ok(MovieMapper.INSTANCE.entityToDto(resultMovie));
    }

    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovieDTO>> getMovieQuery(@RequestBody MovieQueryDTO movieQueryDTO) {
        List<Movie> resultMovies = movieService.getMoviesFromQuery(movieQueryDTO);
        List<MovieDTO> response = MovieMapper.INSTANCE.entityToDto(resultMovies);
        return ResponseEntity.ok(response);
    }

}
