package com.menekse.baris.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "MOVIES")
@Getter
@NoArgsConstructor
@Setter
public class Movie {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "MOVIE_NAME", length = 100)
    private String movieName;
    @Column(name = "DESCRIPTION", length = 500)
    private String description;
    @Column(name = "PRODUCTION_DATE", length = 500)
    private LocalDate productionDate;
    @Column(name = "DIRECTOR", length = 100)
    private String director;
    @Column(name = "WRITERS", length = 500)
    private String writers;
    private BigDecimal budget;
    @Column(name = "TRAINER_URLS", length = 500)
    private String trainerUrls;
    @Column(name = "POSTER_URLS", length = 500)
    private String posterUrls;
    @Column(name = "IMAGE_URLS", length = 500)
    private String imageUrls;
    @Column(name = "CREATED_COMPANY_INFO", length = 100)
    private String createdCompanyInfo;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ActorInfo> actorInfos = new ArrayList<>();

    public void addListActorInfo(ActorInfo actorInfo) {
        actorInfo.setMovie(this);
        this.actorInfos.add(actorInfo);

    }

    public void clearList() {
        this.actorInfos.clear();
    }

}
