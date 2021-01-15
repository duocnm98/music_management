package com.music.management.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "song")
public class Song {

	@Column
	@Id
	@GeneratedValue
	private String id;

	@Column
	private String name;

	@Column(name = "genre_id")
	private Genre genre;

	@Column(name = "singer_id")
	private List<Singer> singers;

	@Column(name = "composer_id")
	private List<Composer> composers;

	@Column
	private Date releaseDate;
}
