package com.librarymanagement.repository;

import com.librarymanagement.domain.Author;
import com.librarymanagement.domain.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Author, Integer>{

  List<Book> findBookByAuthorId(int author);
  List<Book> findBookByBookCatogary(String bookCatagory);
  List<Book> findBookByBookName(String bookName);
  List<Book> findBookByPublisherId(int id);

}
