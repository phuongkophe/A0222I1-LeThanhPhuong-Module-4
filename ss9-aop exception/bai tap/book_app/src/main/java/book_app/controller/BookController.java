package book_app.controller;

import book_app.entity.Book;
import book_app.entity.LibraryCard;
import book_app.service.BookService;
import book_app.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    LibraryCardService libraryCardService;

    @GetMapping
    public ModelAndView listBooks() {
        Iterable<Book> bookList = bookService.findAll();
        return new ModelAndView("books/list","bookList",bookList);
    }

    @GetMapping("borrow/{id}")
    public ModelAndView borrowForm(@PathVariable("id") Long id) {
        Optional<Book> book = bookService.findById(id);
        if(book.isPresent()) {
            if(book.get().getQuantity() > 0) {
                Long libraryCardCode = new Random().nextInt(90000) + 10000L;
                LibraryCard libraryCard = new LibraryCard();
                libraryCard.setLibraryCardCode(""+libraryCardCode);
                libraryCard.setBook(book.get());
                ModelAndView modelAndView = new ModelAndView("books/borrow");
                modelAndView.addObject("libraryCard",libraryCard);

                return modelAndView;
            }else {
                return new ModelAndView("error-404");
            }

        }else {
            return new ModelAndView("error-404");
        }
    }
    @PostMapping("borrow")
    public String borrow(@ModelAttribute LibraryCard libraryCard) {
            libraryCardService.save(libraryCard);
            return "redirect:/books";
    }

}
