package com.librarymanagement.controller;

import com.librarymanagement.model.Authordetail;
import com.librarymanagement.service.AuthorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/library")
public class LibraryManagementAuthorController {
  
  @Autowired
  private AuthorService authorService;

  @PostMapping("/author")
  public ResponseEntity<Object> addAuthor(@RequestBody List<Authordetail> authorDetail) {
    authorService.addAuthor(authorDetail);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/author")
  public ResponseEntity<Authordetail> editAuthor(@RequestBody Authordetail authorDetail) {
    authorService.modifyAuthor(authorDetail);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/author")
  public ResponseEntity<Object> deleteAuthor(@RequestParam int authorId) {
    authorService.deleteAuthor(authorId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    
  }

}
