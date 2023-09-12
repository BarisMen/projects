package com.menekse.baris.dto;

import com.menekse.baris.entity.Movie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActorInfoDTO {
    private Long actorId;
    private String actors;
    private String actorsAndRoles;
}
