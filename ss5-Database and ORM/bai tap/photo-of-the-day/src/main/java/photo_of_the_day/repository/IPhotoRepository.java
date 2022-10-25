package photo_of_the_day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photo_of_the_day.model.Photo;

public interface IPhotoRepository extends JpaRepository<Photo,Integer> {
    Photo findAllByPhotoLinkContaining(String src);
}
