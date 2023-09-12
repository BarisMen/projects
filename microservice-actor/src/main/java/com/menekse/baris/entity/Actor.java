package com.menekse.baris.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ACTORS")
@Getter
@Setter
@NoArgsConstructor
public class Actor {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "NAME", length = 100)
    private String name;
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
    @Column(name = "HEIGHT")
    private Integer height;
    @Column(name = "PERSONAL_SUMMARY", length = 500)
    private String personalSummary;
    @Column(name = "IMAGES", length = 500)
    private String images;
    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<MovieInfo> movieInfos = new ArrayList<>();

    public void addListMovieInfo(MovieInfo movieInfo) {
        movieInfo.setActor(this);
        this.movieInfos.add(movieInfo);

    }

    public void clearList() {
        this.movieInfos.clear();
    }
}


