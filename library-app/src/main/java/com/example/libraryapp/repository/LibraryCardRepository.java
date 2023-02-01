package com.example.libraryapp.repository;

import com.example.libraryapp.model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Long> {
    LibraryCard findByLibararyCardCodeContaining(String libCardCode);
}
