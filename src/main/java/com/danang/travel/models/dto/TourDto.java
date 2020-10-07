package com.danang.travel.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourDto {

    private Integer id;

    @NonNull
    @NotEmpty
    private String name;

    @NonNull
    @NotEmpty
    private String duration;

    private String price;

    private String poster;

    private String address;

    private String description;

}
