package com.learnee.learneebackend.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Column(length = 50, nullable = false)
    @Getter @Setter private String fname;
    @Column(length = 50, nullable = false)
    @Getter @Setter private String lname;
    @Column(length = 50, nullable = false)
    @Getter @Setter private String promotion;
    @Column(length = 50, nullable = false)
    @Getter @Setter private String address;
    @Column(length = 50, nullable = false)
    @Getter @Setter private String email;
    @Column(length = 20, nullable = false)
    @Getter @Setter private String mobile;
    @Column(nullable = false)
    @Getter @Setter private int absence;
    @Column(nullable = false)
    @Getter @Setter private Boolean representative;
}
