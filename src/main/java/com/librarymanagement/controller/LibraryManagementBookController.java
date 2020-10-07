package com.librarymanagement.controller;

import com.librarymanagement.domain.Book;
import com.librarymanagement.model.BookDetail;
import com.librarymanagement.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/library")
public class LibraryManagementBookController {
  
  @Autowired
  private BookService bookService;
  
  @GetMapping("/book")
  public ResponseEntity<List<Book>> getBook(@RequestParam int authorId, @RequestParam String bookName,
      @RequestParam int publisherId, @RequestParam String bookCatagory) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(bookService.searchBook(bookName, bookCatagory, authorId, publisherId));
  }

  @PostMapping("/book")
  public ResponseEntity<Object> addBook(@RequestBody List<BookDetail> bookDetail) {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/Book")
  public ResponseEntity<BookDetail> editBook(@RequestBody BookDetail bookDetail) {
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/Book")
  public ResponseEntity<Object> deleteBook(@RequestParam int bookId) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
