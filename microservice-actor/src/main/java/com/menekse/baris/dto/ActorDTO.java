package com.menekse.baris.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class ActorDTO {
    private Long Id;
    private String name;
    private LocalDate birthDate;
    private Integer height;
    private String personalSummary;
    private String images;
    private List<MovieInfoDTO> movieInfos = new ArrayList<>();
}