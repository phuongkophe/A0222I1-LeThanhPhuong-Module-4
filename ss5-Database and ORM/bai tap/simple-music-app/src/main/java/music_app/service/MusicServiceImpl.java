package music_app.service;

import music_app.entity.Music;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class MusicServiceImpl implements MusicService {
    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<Music> getAll() {
        String strQuery = "SELECT m FROM Music AS m";
        return entityManager.createQuery(strQuery, Music.class).getResultList();
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class,id);
    }

    @Override
    public Music findByName(String name) {
        return entityManager.find(Music.class,name);
    }

    @Override
    public void create(Music music) {
        entityManager.persist(music);
    }

    @Override
    public void update(Music music) {
        entityManager.merge(music);
    }

    @Override
    public void delete(int id) {
        Music music = findById(id);
        entityManager.remove(music);
    }
}
