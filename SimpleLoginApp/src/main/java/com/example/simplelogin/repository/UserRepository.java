package com.example.simplelogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplelogin.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long>{

}
