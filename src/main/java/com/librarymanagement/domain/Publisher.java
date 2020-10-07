package com.librarymanagement.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Publisher {

  private String publisherId;
  private String publisherName;
  @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "publisherId")
  private List<Book> books;

  public String getPublisherId() {
    return publisherId;
  }

  public void setPublisherId(String publisherId) {
    this.publisherId = publisherId;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

}
