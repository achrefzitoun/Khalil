package com.example.back.Controllers;

import com.example.back.Entites.Book;
import com.example.back.Services.IBookServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private IBookServices bookService;

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveBook(@RequestParam("book") String bookString,
                                           @RequestParam("image") MultipartFile image) {
        try {
            Book book = new ObjectMapper().readValue(bookString, Book.class);
            bookService.save(book, image);
            return ResponseEntity.ok("Book saved successfully with image.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while saving the book.");
        }
    }
}
