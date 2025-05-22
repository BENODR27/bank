package com.beno.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beno.bank.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
