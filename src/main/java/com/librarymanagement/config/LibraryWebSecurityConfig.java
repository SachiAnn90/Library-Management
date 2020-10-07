package com.librarymanagement.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LibraryWebSecurityConfig {
  
  
  @Autowired
  private DataSource dataSource;
   
  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
          .dataSource(dataSource)
          .authoritiesByUsernameQuery("select username, role from users where username=?");
  }

  protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
          .anyRequest().authenticated()
          .antMatchers("/library/search").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
          .antMatchers().hasAnyRole("ROLE_ADMIN")
          .and()
          .formLogin().permitAll()
          .and()
          .logout().permitAll();     
  }

}
