package photo_of_the_day.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photo_of_the_day.model.Photo;
import photo_of_the_day.repository.IPhotoRepository;

import java.util.List;
@Service
public class PhotoService implements IPhotoService {
    @Autowired
    IPhotoRepository photoRepository;

    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public Photo findById(int id) {
        return photoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Photo photo) {
        List<Photo> photos = photoRepository.findAll();
        if(photos.size()==0) {
            photoRepository.save(photo);
        }else {
            if(photoRepository.findAllByPhotoLinkContaining(photo.getPhotoLink()) == null) {
                photoRepository.save(photo);
            }
        }

    }

    @Override
    public Photo findAllByPhotoLinkContaining(String src) {
        return photoRepository.findAllByPhotoLinkContaining(src);
    }
}
