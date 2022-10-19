package photo_of_the_day.model;


import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String photoLink;

    @OneToMany(targetEntity = FeedBack.class)
    private List<FeedBack> feedBacks;

    public Photo() {
    }

    public Photo(int id, String photoLink, List<FeedBack> feedBacks) {
        this.id = id;
        this.photoLink = photoLink;
        this.feedBacks = feedBacks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public List<FeedBack> getFeedBacks() {
        return feedBacks;
    }

    public void setFeedBacks(List<FeedBack> feedBacks) {
        this.feedBacks = feedBacks;
    }
}
