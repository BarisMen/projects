package com.menekse.baris.service.impl;

import com.menekse.baris.dto.MovieQueryDTO;
import com.menekse.baris.entity.ActorInfo;
import com.menekse.baris.entity.Movie;
import com.menekse.baris.repository.MovieRepository;
import com.menekse.baris.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.menekse.baris.repository.MovieSpecification.*;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie add(Movie movie) {
        List<ActorInfo> actorInfos = new ArrayList<>();
        actorInfos.addAll(movie.getActorInfos());
        movie.clearList();
        for (ActorInfo actorInfo : actorInfos) {
            movie.addListActorInfo(actorInfo);
        }
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateById(Long id, Movie movie) {
        Movie resultMovie = movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie is not found!"));
        resultMovie.setMovieName(movie.getMovieName());
        resultMovie.setDescription(movie.getDescription());
        resultMovie.setProductionDate(movie.getProductionDate());
        resultMovie.setDirector(movie.getDirector());
        resultMovie.setWriters(movie.getWriters());
/*        resultMovie.setActors(movie.getActors());
        resultMovie.setActorsAndRoles(movie.getActorsAndRoles());*/
        resultMovie.setBudget(movie.getBudget());
        resultMovie.setTrainerUrls(movie.getTrainerUrls());
        resultMovie.setPosterUrls(movie.getPosterUrls());
        resultMovie.setImageUrls(movie.getImageUrls());
        resultMovie.setCreatedCompanyInfo(movie.getCreatedCompanyInfo());
        return movieRepository.save(resultMovie);
    }

    @Override
    public Movie getMovie(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie is not found!"));
    }

    /*
     * Field Nameler Reflection ile alınabilirdi
     * queryDTO.getDescription() ->description field ulaşılabilirdi
     * */
    @Override
    public List<Movie> getMoviesFromQuery(MovieQueryDTO movieQueryDTO) {
        Specification<Movie> spec = null;
        if (StringUtils.hasLength(movieQueryDTO.getMovieName())) {
            spec = hasFieldLike("movieName", movieQueryDTO.getMovieName()).and(spec);
        }
        if (StringUtils.hasLength(movieQueryDTO.getDescription())) {
            spec = hasFieldLike("description", movieQueryDTO.getDescription()).and(spec);
        }
        if (StringUtils.hasLength(movieQueryDTO.getDirector())) {
            spec = hasFieldLike("director", movieQueryDTO.getDirector()).and(spec);
        }
        if (StringUtils.hasLength(movieQueryDTO.getWriters())) {
            spec = hasFieldLike("writers", movieQueryDTO.getWriters()).and(spec);
        }
        if (StringUtils.hasLength(movieQueryDTO.getTrainerUrls())) {
            spec = hasFieldLike("trainerUrls", movieQueryDTO.getTrainerUrls()).and(spec);
        }
        if (StringUtils.hasLength(movieQueryDTO.getPosterUrls())) {
            spec = hasFieldLike("posterUrls", movieQueryDTO.getPosterUrls()).and(spec);
        }
        if (StringUtils.hasLength(movieQueryDTO.getImageUrls())) {
            spec = hasFieldLike("imageUrls", movieQueryDTO.getImageUrls()).and(spec);
        }

        if (StringUtils.hasLength(movieQueryDTO.getCreatedCompanyInfo())) {
            spec = hasFieldLike("createdCompanyInfo", movieQueryDTO.getCreatedCompanyInfo()).and(spec);
        }
        if (movieQueryDTO.getBudget()!=null && movieQueryDTO.getBudget().intValue()>0) {
            spec = hasFieldEqualInteger("budget", movieQueryDTO.getBudget().intValue()).and(spec);
        }
        if (spec != null) {
            return movieRepository.findAll(spec);
        } else {
            return movieRepository.findAll();
        }

    }

}
