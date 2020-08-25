package com.danang.travel.models.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class TicketVisit {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_visit_id")
    private List<Image> images;

}
