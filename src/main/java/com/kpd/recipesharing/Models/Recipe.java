package com.kpd.recipesharing.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne // Many->recipes by one->user
    private User user;

    private String image;

    private String description;

    private boolean vegetarian;

    private LocalDateTime createdAt;

    private List<Long> likes = new ArrayList<>();

}
