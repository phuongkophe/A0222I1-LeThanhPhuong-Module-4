package photo_of_the_day.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import photo_of_the_day.model.FeedBack;
import photo_of_the_day.repository.IFeedBackRepository;

import java.util.List;

@Service
public class FeedBackService implements IFeedBackService {
    @Autowired
    IFeedBackRepository feedBackRepository;

    @Override
    public List<FeedBack> findAll() {
        return feedBackRepository.findAll();
    }

    @Override
    public FeedBack findById(int id) {
        return feedBackRepository.findById(id).orElse(null);
    }

    @Override
    public void save(FeedBack feedBack) {
        feedBackRepository.save(feedBack);
    }

    @Override
    public List<FeedBack> findAllByPhotoId(int id) {
        return feedBackRepository.findAllByPhotoId(id);
    }
}
