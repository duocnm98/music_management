package com.music.management.DAO;

import com.music.management.entity.Person;
import com.music.management.entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public abstract class PersonDAO {

    SessionFactory sessionFactory;

    public Person getPerson(String personId) {
        String sql = "SELECT * FROM song WHERE id = " + personId;
        Session session = this.sessionFactory.getCurrentSession();
        Query<Song> query = session.createQuery(sql, Song.class);

        Song value = (Song) query.getResultList();
        if (value == null) return null;
        return value;

        return Person;
    }

    public void savePerson() {

    }

    public void detelePerson() {

    }



}
