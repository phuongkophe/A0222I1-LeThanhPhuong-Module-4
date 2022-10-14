package music_app.service;

import music_app.entity.Music;

import java.util.List;

public interface MusicService {
    List<Music> getAll();
    Music findById(int id);
    Music findByName(String name);
    void create(Music music);
    void update(Music music);
    void delete(int id);
}
