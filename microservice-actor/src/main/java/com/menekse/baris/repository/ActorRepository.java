package com.menekse.baris.repository;

import com.menekse.baris.entity.Actor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findAll(Specification<Actor> spec);
}
