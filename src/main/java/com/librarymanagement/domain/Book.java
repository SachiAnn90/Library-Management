package com.librarymanagement.domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Book {
  
  private long bookId;
  private String bookName;
  private String bookCatagory;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "publisherId", nullable = false)
  private Publisher publisher;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "authorId", nullable = false)
  private Author author;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "userId", nullable = false)
  private User user;

  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getBookCatagory() {
    return bookCatagory;
  }

  public void setBookCatagory(String bookCatagory) {
    this.bookCatagory = bookCatagory;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
