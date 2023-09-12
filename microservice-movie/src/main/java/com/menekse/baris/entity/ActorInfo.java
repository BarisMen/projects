package com.menekse.baris.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "MOVIE_INFO")
@Getter
@Setter
@NoArgsConstructor
public class ActorInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "ACTOR_ID")
    private Long actorId;
    @Column(name = "ACTORS", length = 500)
    private String actors;
    @Column(name = "ACTORS_AND_ROLES", length = 500)
    private String actorsAndRoles;
    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;
}
