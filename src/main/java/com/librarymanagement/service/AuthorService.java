package com.librarymanagement.service;

import com.librarymanagement.domain.Author;
import com.librarymanagement.model.Authordetail;
import com.librarymanagement.repository.AuthorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  public void addAuthor(List<Authordetail> authorDetail) {

    if (authorDetail != null && !authorDetail.isEmpty()) {
      List<Author> authors = new ArrayList<>();
      for (Authordetail detail : authorDetail) {

        Author author = new Author();
        author.setAuthorName(detail.getAuthorName());
        authors.add(author);
      }

      authorRepository.saveAll(authors);
    }

  }

  public void modifyAuthor(Authordetail authorDetail) {

    if (authorDetail != null) {
      Optional<Author> authorOpt = authorRepository.findById(authorDetail.getAuthorId());
      if (authorOpt.isPresent()) {
        Author author = authorOpt.get();
        author.setAuthorName(authorDetail.getAuthorName());
        authorRepository.save(author);
      }
    }

  }

  public void deleteAuthor(int authorId) {

    if (authorId != 0) {
      authorRepository.deleteById(authorId);
    }

  }

}
