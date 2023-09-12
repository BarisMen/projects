package com.menekse.baris.service;

import com.menekse.baris.dto.MovieQueryDTO;
import com.menekse.baris.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie add(Movie movie);

    List<Movie> getMovies();

    Movie updateById(Long id, Movie movie);

    Movie getMovie(Long id);

    List<Movie> getMoviesFromQuery(MovieQueryDTO movieQueryDTO);
}
