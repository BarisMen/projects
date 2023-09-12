package com.example.apigateway.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MovieQueryDTO implements Serializable {
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
}
