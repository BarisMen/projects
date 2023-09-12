package com.menekse.baris.service;

import com.menekse.baris.dto.QueryDTO;
import com.menekse.baris.entity.Actor;

import java.util.List;

public interface ActorService {
    Actor add(Actor actor);

    List<Actor> getActors();

    Actor updateById(Long id, Actor actor);

    Actor getActor(Long id);

    List<Actor> getActorsFromQuery(QueryDTO queryDTO);
}
