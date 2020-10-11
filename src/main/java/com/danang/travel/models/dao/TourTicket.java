package com.danang.travel.models.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TourTicket {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column (length = 50000)
    private String description;
}
