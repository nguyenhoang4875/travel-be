package com.danang.travel.models.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TourPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String description;

}
