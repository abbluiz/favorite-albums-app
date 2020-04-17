package com.abbluiz;

import com.abbluiz.entity.Album;
import com.abbluiz.service.AlbumService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class EditAlbumView implements Serializable {

    private String name;
    private int number;
    private String team;
    private String country;

    @EJB
    private AlbumService albumService;
    private transient Album albumToUpdate;

    public void populateView(long albumId) {

        albumToUpdate = albumService.findById(albumId);
        this.setName(albumToUpdate.getName());
        this.setCountry(albumToUpdate.getCountry());
        this.setNumber(albumToUpdate.getNumber());
        this.setTeam(albumToUpdate.getTeam());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String save() {

        Album createdAlbum = new Album(name, number, team, country);

        if (albumToUpdate != null) {

            createdAlbum.setId(albumToUpdate.getId());
            albumService.update(createdAlbum);

        } else {
            albumService.create(createdAlbum);
        }

        nullifyFields();
        return "/albums.xhtml?faces-redirect=true";

    }

    private void nullifyFields() {

        albumToUpdate = null;
        this.setTeam(null);
        this.setNumber(0);
        this.setCountry(null);
        this.setName(null);

    }

}
