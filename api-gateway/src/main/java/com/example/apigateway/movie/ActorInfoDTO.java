package com.example.apigateway.movie;

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
