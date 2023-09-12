package com.menekse.baris.repository;

import com.menekse.baris.entity.Actor;
import com.menekse.baris.entity.MovieInfo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ActorSpecification {

    public static Specification<Actor> hasFieldLike(String fieldName, String value) {
        //return (Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.like(builder.function("ILIKE", String.class, root.get(fieldName), builder.literal("%" + value + "%")), "%");
        return (Root<Actor> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.like(root.get(fieldName), "%" + value + "%");
    }


    public static Specification<Actor> hasFieldIn(String fieldName, List<Long> values) {
        //return (Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.like(builder.function("ILIKE", String.class, root.get(fieldName), builder.literal("%" + value + "%")), "%");
        return (Root<Actor> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.in(root.get(fieldName)).value(values);
    }


    public static Specification<Actor> hasFieldEqualInteger(String fieldName, Integer value) {
        return (Root<Actor> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.equal(root.get(fieldName), value);
    }

    public static Specification<Actor> hasJoinMovieInfo( List<Long> movieIds) {
        return (root, query, criteriaBuilder) -> {
            Join<Actor, MovieInfo> movieJoin = root.join("movies");
            return criteriaBuilder.in(movieJoin.get("id")).value(movieIds);
        };
    }

    public static Specification<Actor> hasJoinMovieInfoLike( String fieldName, String value) {
        return (root, query, criteriaBuilder) -> {
            Join<Actor, MovieInfo> movieJoin = root.join("movies");
            return criteriaBuilder.like(movieJoin.get(fieldName),"%" + value + "%");
        };
    }


}
