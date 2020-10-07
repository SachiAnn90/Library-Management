package com.librarymanagement.controller;

import com.librarymanagement.model.UserDetail;
import com.librarymanagement.service.UserService;
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
public class LibraryManagementUserController {
  
  @Autowired
  private UserService userService;

  @PostMapping("/user")
  public ResponseEntity<Object> addUser(@RequestBody List<UserDetail> userDetail) {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/user")
  public ResponseEntity<UserDetail> editUser(@RequestBody UserDetail userDetail) {
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/user")
  public ResponseEntity<Object> deleteUser(@RequestParam int userId) {
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    
  }
  

}
