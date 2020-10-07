package com.danang.travel.models.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @NonNull
    @NotEmpty
    private String name;

    @NonNull
    @NotEmpty
    @NotNull
    private String duration;

    @Column
    private String price;

    @Column (length = 1000)
    private String address;

    @Column
    private String poster;

    @Column (length = 5000)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_ticket_id")
    private TourTicket tourTicket;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_schedule_id")
    private TourSchedule tourSchedule;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_policy_id")
    private TourPolicy tourPolicy;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    private List<Image> images = new ArrayList<>();

}
