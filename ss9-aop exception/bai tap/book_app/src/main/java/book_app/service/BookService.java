package book_app.service;

import book_app.entity.Book;

public interface BookService extends GeneralService<Book> {
    int update(Integer quantity,Long id);
}
