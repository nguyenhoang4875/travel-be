package com.danang.travel.models.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

}
