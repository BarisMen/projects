package com.menekse.baris.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MOVIE_INFO")
@Getter
@Setter
@NoArgsConstructor
public class MovieInfo {
    @jakarta.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "MOVIE_ID")
    private Long movieID;

    @Column(name = "ROLED_MOVIES", nullable = true, length = 500)
    private String roledMovies;
    @Column(name = "ROLED_CHARACTERS", nullable = true, length = 500)
    private String roledCharacter;
    @ManyToOne
    @JoinColumn(name = "ACTOR_ID")
    private Actor actor;

}
