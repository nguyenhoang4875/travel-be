package com.danang.travel.models.dao;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column(length = 5000)
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "promotion_id")
    private List<Image> images= new ArrayList<>();
}
