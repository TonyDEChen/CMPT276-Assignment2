package com.cmpt276.as2.models;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByName(String name);
    List<User> findById(int id);
}
