package com.abbluiz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "findAllAlbums", query = "SELECT a FROM Album a")
})
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String artist;
    private int year;
    private int numberOfTracks;
    private String predominantGenre;
    private String label;
    private String coverUrl;

    public Album(String name, String artist, int year, int numberOfTracks,
                 String predominantGenre, String label, String coverUrl) {

        this.name = name;
        this.artist = artist;
        this.year = year;
        this.numberOfTracks = numberOfTracks;
        this.predominantGenre = predominantGenre;
        this.label = label;
        this.coverUrl = coverUrl;

    }

}
