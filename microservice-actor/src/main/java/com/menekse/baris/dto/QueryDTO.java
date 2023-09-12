package com.menekse.baris.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class QueryDTO {
    private List<Long> movieIds;
    private Long Id;
    private String name;
    private LocalDate birthDate;
    private Integer height;
    private String personalSummary;
    private String images;
    private String roledMovies;
    private String roledCharacter;

}
