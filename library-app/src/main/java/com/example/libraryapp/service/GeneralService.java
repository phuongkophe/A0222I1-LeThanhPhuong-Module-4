package com.example.libraryapp.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface GeneralService<T> {
   Iterable<T> findAll();
   Optional<T> findById(Long id);
}
