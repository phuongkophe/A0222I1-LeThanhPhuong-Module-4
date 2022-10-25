package music_app.validator;

import music_app.entity.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
            if(!song.getName().matches("[a-z A-Z 0-9]*")) {
            errors.rejectValue("name","song.symbol","Invalid input");
        }
        if(!song.getAuthor().matches("[a-z A-Z 0-9]*")) {
            errors.rejectValue("author","song.symbol","Invalid input");
        }
        if(!song.getCategory().matches("[a-z A-Z \\,]*")) {
            errors.rejectValue("category","song.symbol","Invalid input");
        }
    }
}
