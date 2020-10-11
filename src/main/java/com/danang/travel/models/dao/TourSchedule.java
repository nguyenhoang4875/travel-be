package com.danang.travel.models.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TourSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 50000)
    private String description;

}
