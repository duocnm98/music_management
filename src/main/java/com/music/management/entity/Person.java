package com.music.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
        @Column
        @Id
        @GeneratedValue
        private String id;

        @Column
        private String name;

        @Column
        private Date birthday;

        @Column
        private String gender;

        @Column
        private List<Song> songList;
}
