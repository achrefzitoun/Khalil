package com.example.back.Repositories;

import com.example.back.Entites.Book;
import com.example.back.Entites.TypeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

    Book findByIsbn(Integer isbn);

    void deleteByIsbn(Integer isbn);

    List<Book> findAllByTypeBooksContaining(TypeBook typeBook);
}