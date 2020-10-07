package com.librarymanagement.service;

import com.librarymanagement.domain.Book;
import com.librarymanagement.domain.User;
import com.librarymanagement.repository.BookRepository;
import com.librarymanagement.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;
  
  @Autowired
  private UserRepository userRepository;

  public List<Book> searchBook(String bookName, String bookCatagory, int authorId,
      int publisherId) {

    List<Book> books = new ArrayList<>();
     if (bookName != null && !bookName.isEmpty()) {
       books = bookRepository.findBookByBookName(bookName);
    } else if (bookCatagory != null && !bookCatagory.isEmpty()) {
      books = bookRepository.findBookByBookCatogary(bookCatagory);
    } else if (authorId != 0) {
      books = bookRepository.findBookByAuthorId(authorId);
    } else if (publisherId != 0) {
      books = bookRepository.findBookByPublisherId(publisherId);
    }
     
     return books;
  }
  
  public Book lendBook(String bookName, String userName) {
    List<Book> books = bookRepository.findBookByBookName(bookName);
    Book book = null;
    if(!books.isEmpty()) {
      book = books.get(0);
      User user = book.getUser();
      if(user.getUserName() == null) {
        user = userRepository.findUserByUserName(userName);
        book.setUser(user);
      }
    }
    
    return book;

  }
  

}
