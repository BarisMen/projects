package com.menekse.baris.api;

import com.menekse.baris.dto.ActorDTO;
import com.menekse.baris.dto.QueryDTO;
import com.menekse.baris.entity.Actor;
import com.menekse.baris.mapper.ActorMapper;
import com.menekse.baris.service.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping
    public ResponseEntity<ActorDTO> add(@RequestBody ActorDTO actorDto) {
        Actor resultActor = actorService.add(ActorMapper.INSTANCE.dtoToEntitiy(actorDto));
        return ResponseEntity.ok(ActorMapper.INSTANCE.entityToDTO(resultActor));
    }

    @GetMapping
    public ResponseEntity<List<ActorDTO>> getActors() {
        List<Actor> resultActors = actorService.getActors();
        return ResponseEntity.ok(ActorMapper.INSTANCE.entitiesToDTOs(resultActors));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorDTO> updateById(@PathVariable("id") Long id, @RequestBody ActorDTO actorDTO) {
        Actor resultActor = actorService.updateById(id, ActorMapper.INSTANCE.dtoToEntitiy(actorDTO));
        return ResponseEntity.ok(ActorMapper.INSTANCE.entityToDTO(resultActor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActor(@PathVariable("id") Long id) {
        Actor resultActor = actorService.getActor(id);
        return ResponseEntity.ok(ActorMapper.INSTANCE.entityToDTO(resultActor));
    }

    @PostMapping("/query")
    public ResponseEntity<List<ActorDTO>> getMovieQuery(@RequestBody QueryDTO queryDTO) {
        List<Actor> resultQuery = actorService.getActorsFromQuery(queryDTO);
        return ResponseEntity.ok(ActorMapper.INSTANCE.entitiesToDTOs(resultQuery));
    }




}
