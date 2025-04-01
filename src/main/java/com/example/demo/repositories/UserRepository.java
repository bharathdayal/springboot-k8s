package com.example.demo.repositories;


import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

   @Query("SELECT u from User u WHERE u.email=?1")
   User findByEmail(String email);

   User findByUsername(String username);

   User findByUsernameOrEmail(String username,String email);

   @Query(name="User.findByUsernameAll")
   String findByUsernameAll(@Param("userName") String userName);

}