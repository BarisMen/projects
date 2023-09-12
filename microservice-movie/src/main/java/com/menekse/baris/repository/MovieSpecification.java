package com.menekse.baris.repository;

import com.menekse.baris.entity.ActorInfo;
import com.menekse.baris.entity.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

@UtilityClass
public class MovieSpecification {


    public static Specification<Movie> hasFieldLike(String fieldName,String value) {
//        return (Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.like(builder.function("ILIKE", String.class, root.get(fieldName), builder.literal("%" + value + "%")), "%");
        return (Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.like(root.get(fieldName), "%" + value + "%");
    }

    public static Specification<Movie> hasFieldEqualInteger(String fieldName,Integer value) {
        return (Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> builder.equal(root.get(fieldName), value);
    }
    public static Specification<Movie> hasJoinActorInfo( String fieldName,String value) {
        return (root, query, criteriaBuilder) -> {
            Join<Movie, ActorInfo> movieJoin = root.join("movie");
            return criteriaBuilder.in(movieJoin.get(fieldName)).value(value);
        };
    }


}
