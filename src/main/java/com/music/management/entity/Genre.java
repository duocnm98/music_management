package com.music.management.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @Column
    @GeneratedValue
    private String id;

    @Column
    private String name;
}
