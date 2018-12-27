package com.khja021.dao;

import com.khja021.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

   // void addUser(User user);
  //  void updateUser(User user);
 //   User getUser(int id);
    User findUserByUsername(String username);
 //   List<User> getUsers();
}
