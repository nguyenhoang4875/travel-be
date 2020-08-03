package com.danang.travel.models.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TiketVisit {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String imageUrl;

    @Column
    private String description;

}
