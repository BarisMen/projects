package com.menekse.baris.dto;

import com.menekse.baris.entity.Actor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieInfoDTO {
    private Long Id;
    private Long movieID;
    private String roledMovies;
    private String roledCharacter;

}
