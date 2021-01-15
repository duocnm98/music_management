package com.music.management.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @Column
    @GeneratedValue
    private String id;

    @Column
    private String name;

    @Column
    private List<Song> songList;
}
