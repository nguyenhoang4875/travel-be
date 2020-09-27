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

    @Column
    private String name;

    @Column
    private String imageUrl;

    @Column(length = 5000)
    private String description;

}
