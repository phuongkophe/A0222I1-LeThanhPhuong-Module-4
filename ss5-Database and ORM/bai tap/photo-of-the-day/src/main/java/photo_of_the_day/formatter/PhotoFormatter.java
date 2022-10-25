package photo_of_the_day.formatter;

import org.springframework.format.Formatter;
import photo_of_the_day.model.Photo;
import photo_of_the_day.service.IPhotoService;

import java.text.ParseException;
import java.util.Locale;

public class PhotoFormatter implements Formatter<Photo> {
    private IPhotoService photoService;

    public PhotoFormatter(IPhotoService photoService){
        this.photoService = photoService;
    }

    @Override
    public Photo parse(String id, Locale locale) throws ParseException {
        Photo photo = photoService.findById(Integer.parseInt(id));
        return null;
    }

    @Override
    public String print(Photo object, Locale locale) {
        return null;
    }
}
