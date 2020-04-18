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
    private String artist;
    private int year;
    private int numberOfTracks;
    private String predominantGenre;
    private String label;
    private String coverUrl;

    @EJB
    private AlbumService albumService;
    private transient Album albumToUpdate;

    public void populateView(long albumId) {

        albumToUpdate = albumService.findById(albumId);
        this.setName(albumToUpdate.getName());
        this.setArtist(albumToUpdate.getArtist());
        this.setYear(albumToUpdate.getYear());
        this.setNumberOfTracks(albumToUpdate.getNumberOfTracks());
        this.setPredominantGenre(albumToUpdate.getPredominantGenre());
        this.setLabel(albumToUpdate.getLabel());
        this.setCoverUrl(albumToUpdate.getCoverUrl());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public String getPredominantGenre() {
        return predominantGenre;
    }

    public void setPredominantGenre(String predominantGenre) {
        this.predominantGenre = predominantGenre;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String save() {

        Album createdAlbum = new Album(name, artist, year, numberOfTracks, predominantGenre, label, coverUrl);

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
        this.setName(null);
        this.setArtist(null);
        this.setYear(0);
        this.setNumberOfTracks(0);
        this.setPredominantGenre(null);
        this.setLabel(null);
        this.setCoverUrl(null);

    }

}
