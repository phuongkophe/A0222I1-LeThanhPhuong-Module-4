package photo_of_the_day.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import photo_of_the_day.model.FeedBack;

import java.util.List;

public interface IFeedBackRepository extends JpaRepository<FeedBack,Integer> {
    List<FeedBack> findAllByPhotoId(int id);
}
