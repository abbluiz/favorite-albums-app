package com.abbluiz.service;

import com.abbluiz.entity.Album;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class AlbumService {

    @PersistenceContext(unitName = "albumPersistenceUnit")
    private EntityManager manager;

    public List<Album> getAll() {
        return manager.createNamedQuery("findAllAlbums", Album.class).getResultList();
    }

    public Album findById(long id) {
        return manager.find(Album.class, id);
    }

    @Transactional
    public void update(Album album) {

        manager.getTransaction().begin();
        manager.merge(album);
        manager.getTransaction().commit();

    }

    @Transactional
    public void create(Album album) {

        manager.getTransaction().begin();
        manager.persist(album);
        manager.getTransaction().commit();

    }

    @Transactional
    public void delete(Album album) {

        manager.getTransaction().begin();

        if (!manager.contains(album)) {
            album = manager.merge(album);
        }

        manager.remove(album);
        manager.getTransaction().commit();

    }

}
