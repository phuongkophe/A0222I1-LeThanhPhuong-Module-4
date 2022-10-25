package photo_of_the_day.service;

import photo_of_the_day.model.Photo;

import java.util.List;

public interface IPhotoService {
    List<Photo> findAll();
    Photo findById(int id);
    void save(Photo photo);
    Photo findAllByPhotoLinkContaining(String src);
}
