package com.databaseProject.databaseProject.Repositories;

import com.databaseProject.databaseProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("SELECT user FROM UserDto user WHERE user.email = ?1")
    public User findByEmail(String email);
    public void deleteByEmail(String email);
}
