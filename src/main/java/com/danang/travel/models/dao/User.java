package com.danang.travel.models.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @NotNull
    @Column(unique = true)
    @NonNull
    @NotEmpty
    private String username;


    @NonNull
    @Column(length = 70)
    @NotEmpty
    @NotNull
    private String password;

    @Column
    @NonNull
    @NotNull
    @NotEmpty
    private String firstName;

    @Column
    @NonNull
    @NotNull
    @NotEmpty
    private String lastName;

    @Column
    private String email;

    @Column
    private String avatar;

    @Column
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
