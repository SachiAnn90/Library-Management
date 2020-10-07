package com.librarymanagement.controller;

import com.librarymanagement.model.PublisherDetail;
import com.librarymanagement.service.PublisherService;
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
public class LibraryManagementPublisherController {
  
  @Autowired
  private PublisherService publisherService;

  @PostMapping("/publisher")
  public ResponseEntity<Object> addPublisher(@RequestBody List<PublisherDetail> publisherDetail) {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/publisher")
  public ResponseEntity<PublisherDetail> editPublisher(@RequestBody PublisherDetail publisherDetail) {
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/publisher")
  public ResponseEntity<Object> deletePublisher(@RequestParam int publisherId) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    
  }

}
