package com.example.libraryapp.service;

import com.example.libraryapp.model.Book;
import com.example.libraryapp.model.LibraryCard;
import com.example.libraryapp.repository.BookRepository;
import com.example.libraryapp.repository.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryCardCodeImpl implements LibraryCardService{
    @Autowired
    LibraryCardRepository libraryCardRepository;

    @Autowired
    BookService bookService;

    @Override
    public Iterable<LibraryCard> findAll() {
        return libraryCardRepository.findAll();
    }

    @Override
    public Optional<LibraryCard> findById(Long id) {
        return libraryCardRepository.findById(id);
    }





    @Override
    public LibraryCard findByLibararyCardCodeContaining(String libCardCode) {
        return libraryCardRepository.findByLibararyCardCodeContaining(libCardCode);
    }
}
