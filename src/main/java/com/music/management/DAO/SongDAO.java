package com.music.management.DAO;

import com.music.management.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class SongDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Song getSong(String songId) {
        String sql = "SELECT * FROM song WHERE id = " + songId;
        Session session = this.sessionFactory.getCurrentSession();
        Query<Song> query = session.createQuery(sql, Song.class);

        Song value = (Song) query.getResultList();
        if (value == null) return null;
        return value;
    }

    public List getSongList() {
        String sql = "SELECT * FROM song";
        Session session = this.sessionFactory.getCurrentSession();
        Query<List> query = session.createQuery(sql, List.class);

        List value = (List) query.getResultList();
        if (value == null) return null;

        return value;
    }


    public void saveSong(Song song) {
        Session session = sessionFactory.getCurrentSession();
        String songId = song.getId();

        Song songToSave = null;

        boolean isNew = false;

        if (songId != null) {
            songToSave = this.getSong(songId);
        }

        if (songToSave == null) {
            isNew = true;
            songToSave = new Song();
            songToSave.setReleaseDate(new Date());
        }

        songToSave.setId(songId);
        songToSave.setName(song.getName());
        songToSave.setComposers(song.getComposers());
        songToSave.setGenre(song.getGenre());
        songToSave.setSingers(song.getSingers());

        if (isNew) session.persist(songToSave);
        session.flush();
    }

    public void deteleSong(String songId) {
        Session session = sessionFactory.getCurrentSession();
        Song songToDelete = new Song();
        songToDelete.setId(songId);
        session.delete(songToDelete);

        session.flush();
    }

    public int getSongAmount() {
        String sql = "SELECT COUNT(id) FROM song";
        Session session = this.sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery(sql, Integer.class);

        Integer value = (Integer) query.getSingleResult();

        return value;
    }
}
