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
    private int number;
    private String team;
    private String country;

    public Album(String name, int number, String team, String country) {

        this.name = name;
        this.number = number;
        this.team = team;
        this.country = country;

    }

}
