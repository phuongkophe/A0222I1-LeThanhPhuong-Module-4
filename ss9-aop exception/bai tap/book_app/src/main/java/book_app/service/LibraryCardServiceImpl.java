package book_app.service;

import book_app.entity.Book;
import book_app.entity.LibraryCard;
import book_app.repository.LibraryCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryCardServiceImpl implements LibraryCardService{
    @Autowired
    LibraryCardRepo libraryCardRepo;

    @Autowired
    BookService bookService;

    @Override
    public Iterable<LibraryCard> findAll() {
        return libraryCardRepo.findAll();
    }

    @Override
    public Optional<LibraryCard> findById(Long id) {
        return libraryCardRepo.findById(id);
    }

    @Override
    public void save(LibraryCard libraryCard) {
        libraryCardRepo.save(libraryCard);
        Book book = bookService.findById(libraryCard.getBook().getId()).get();
        bookService.update(book.getQuantity()-1, book.getId());
    }

    @Override
    public void deleteById(Long id) {
            LibraryCard libraryCard = findById(id).get();
            Book book = bookService.findById(libraryCard.getBook().getId()).get();
            bookService.update(book.getQuantity() + 1, book.getId());
            libraryCardRepo.deleteById(id);
    }

    @Override
    public LibraryCard findByLibraryCardCodeContaining(String libCardCode) {
        return libraryCardRepo.findByLibraryCardCodeContaining(libCardCode);
    }
}
