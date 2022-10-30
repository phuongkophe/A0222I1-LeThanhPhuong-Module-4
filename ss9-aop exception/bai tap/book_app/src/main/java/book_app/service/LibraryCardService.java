package book_app.service;

import book_app.entity.LibraryCard;

public interface LibraryCardService extends GeneralService<LibraryCard> {
    LibraryCard findByLibraryCardCodeContaining(String libCardCode);
}
