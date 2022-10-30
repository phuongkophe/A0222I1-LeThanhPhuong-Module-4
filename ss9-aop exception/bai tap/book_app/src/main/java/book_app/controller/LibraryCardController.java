package book_app.controller;

import book_app.entity.Book;
import book_app.entity.LibraryCard;
import book_app.service.BookService;
import book_app.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("libraryCards")
public class    LibraryCardController {
    @Autowired
    LibraryCardService libraryCardService;
    @Autowired
    BookService bookService;

    @GetMapping
    public ModelAndView listLibraryCards() {
        Iterable<LibraryCard> libraryCardList = libraryCardService.findAll();
        return new ModelAndView("library_cards/list","libraryCardList",libraryCardList);
    }


    @GetMapping("search")
    public ModelAndView showLibCard(@RequestParam("libCardCode") String libCardCode) {
        LibraryCard libraryCard = libraryCardService.findByLibraryCardCodeContaining(libCardCode);
        if(libraryCard == null) {
            return new ModelAndView("error-404");
        }else {
            return new  ModelAndView("library_cards/info","libraryCard",libraryCard);
        }

    }

    @GetMapping("return/{id}")
    public String returnConfirm(@PathVariable("id") Long id) {
        Optional<LibraryCard> libraryCard = libraryCardService.findById(id);
        if(libraryCard.isPresent()) {
            libraryCardService.deleteById(id);
            return "redirect:/books";
        }else {
            return "error-404";
        }
    }

}
