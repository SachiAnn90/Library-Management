package com.librarymanagement.repository;

import com.librarymanagement.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
  
  User findUserByUserName(String username);

}
