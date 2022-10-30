package book_app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libraryCardCode;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public LibraryCard() {
    }

    public LibraryCard(String libraryCardCode) {
        this.libraryCardCode = libraryCardCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibraryCardCode() {
        return libraryCardCode;
    }

    public void setLibraryCardCode(String libraryCardCode) {
        this.libraryCardCode = libraryCardCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
