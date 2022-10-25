package photo_of_the_day.service;

import photo_of_the_day.model.FeedBack;

import java.util.List;

public interface IFeedBackService {
    List<FeedBack> findAll();
    FeedBack findById(int id);
    void save (FeedBack feedBack);
    List<FeedBack> findAllByPhotoId(int id);
}
