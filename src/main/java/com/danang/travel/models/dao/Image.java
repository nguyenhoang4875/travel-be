package com.danang.travel.models.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String url;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "film_id")
    @JsonIgnore
    private Tour tour;

}
