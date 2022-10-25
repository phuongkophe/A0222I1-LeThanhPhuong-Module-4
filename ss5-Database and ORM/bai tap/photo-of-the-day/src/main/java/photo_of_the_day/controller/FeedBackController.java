package photo_of_the_day.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import photo_of_the_day.service.IFeedBackService;
import photo_of_the_day.service.IPhotoService;
import photo_of_the_day.model.FeedBack;
import photo_of_the_day.model.Photo;

@Controller
public class FeedBackController {
    @Autowired
    IFeedBackService feedBackService;

    @Autowired
    IPhotoService photoService;
}
