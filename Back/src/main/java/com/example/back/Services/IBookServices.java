package com.example.back.Services;

import com.example.back.Entites.Book;
import com.example.back.Entites.TypeBook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IBookServices {
    public List<Book> findAll();

    public Book findOne(int isbn);

    public void save(Book book, MultipartFile image);

    public void delete(int isbn);

    boolean checkBookAvailability(int isbn);

    List<Book> findBookByCategory(TypeBook typeBook);
    public File getImage(String path) throws IOException;
}
