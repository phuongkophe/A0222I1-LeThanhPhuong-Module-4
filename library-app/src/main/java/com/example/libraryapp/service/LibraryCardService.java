package com.example.libraryapp.service;

import com.example.libraryapp.model.LibraryCard;

public interface LibraryCardService extends GeneralService<LibraryCard>{
    LibraryCard findByLibararyCardCodeContaining(String libCardCode);
}
