package photo_of_the_day.model;

import javax.persistence.*;

@Entity
@Table
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String author;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_photo")
    private Photo photo;

    public FeedBack() {
    }

    public FeedBack(int id, int rate, String author, String comment, Photo photo) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.comment = comment;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
