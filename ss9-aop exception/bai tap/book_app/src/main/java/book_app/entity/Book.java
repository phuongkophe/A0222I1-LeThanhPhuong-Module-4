package book_app.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String author;
    private String description;
    private Integer quantity;

    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    private List<LibraryCard> libraryCardList;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<LibraryCard> getLibraryCardList() {
        return libraryCardList;
    }

    public void setLibraryCardList(List<LibraryCard> libraryCardList) {
        this.libraryCardList = libraryCardList;
    }
}
