package com.example.demo.repository;

import com.example.demo.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AyUserRepository extends JpaRepository<AyUser,String> {

}
