package music_app.entity;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {

    private int id;
    private String name;
    private String artist;
    private String category;
    private MultipartFile link;

    public MusicForm() {
    }

    public MusicForm(String name, String artist, String category, MultipartFile link) {
        this.name = name;
        this.artist = artist;
        this.category = category;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getLink() {
        return link;
    }

    public void setLink(MultipartFile link) {
        this.link = link;
    }
}
