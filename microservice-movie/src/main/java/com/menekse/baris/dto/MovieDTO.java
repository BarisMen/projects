package com.menekse.baris.dto;

import com.menekse.baris.entity.ActorInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String movieName;
    private String description;
    private LocalDate productionDate;
    private String director;
    private String writers;
    private BigDecimal budget;
    private String trainerUrls;
    private String posterUrls;
    private String imageUrls;
    private String createdCompanyInfo;
    private List<ActorInfoDTO> actorInfos;
}
