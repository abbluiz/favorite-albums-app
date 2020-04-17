package com.abbluiz;

import com.abbluiz.entity.Album;
import com.abbluiz.service.AlbumService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AllAlbumsView {

    private List<Album> albums;

    @EJB
    private AlbumService albumService;

    @PostConstruct
    public void init() {

        albums = new ArrayList<>();
        albums.addAll(albumService.getAll());

    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public String deleteAlbum(long id) {

        albumService.delete(albumService.findById(id));
        return "/albums.xhtml?faces-redirect=true";

    }

    public String redirectToEditAlbum() {
        return "/editAlbum.xhtml?faces-redirect=true";
    }

}
