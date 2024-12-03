package com.example.back.Services.impl;

import com.example.back.Entites.Book;
import com.example.back.Entites.Reservation;
import com.example.back.Entites.TypeBook;
import com.example.back.Repositories.IBookRepository;
import com.example.back.Repositories.IReservationsRepository;
import com.example.back.Services.IBookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class bookServices implements IBookServices {

    private final IBookRepository bookRepository;

    private final IReservationsRepository reservationsRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    private String filePath = "D:\\Khalil\\Back\\src\\main\\resources\\images\\";
    @Override
    public Book findOne(int isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public String sanitizeFileName(String fileName) {
        return fileName.replaceAll("[<>:\"/\\|?*]", "_");
    }
    @Override
    public void save(Book book, MultipartFile image){
        if (!image.isEmpty()) {
            try {
                String imageFileName = book.getIsbn() + "_" + sanitizeFileName(book.getTitle()) + ".jpg";
                Path path = Paths.get(filePath + imageFileName);
                Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                book.setImage(imageFileName);
                bookRepository.save(book);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            bookRepository.save(book);
        }
    }

    @Override
    public void delete(int isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    @Override
    public boolean checkBookAvailability(int isbn) {
        Book book = this.findOne(isbn);
        List<Reservation> reservations = reservationsRepository.findAllByBook(book);
        int nbReservations = 0;
        for (Reservation r : reservations){
            if(LocalDate.now().isAfter(r.getStartDate()) && LocalDate.now().isBefore(r.getEndDate())){
                nbReservations++;
            }
            if(nbReservations == book.getNbCopies()){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Book> findBookByCategory(TypeBook typeBook) {

        return bookRepository.findAllByTypeBookContaining(typeBook);
    }

    public File getImage(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            return file;
        } else {
            throw new IOException("Le fichier spécifié n'existe pas : " + path);
        }
    }
}
