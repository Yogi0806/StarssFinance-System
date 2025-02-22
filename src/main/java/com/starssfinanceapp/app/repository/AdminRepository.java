package com.starssfinanceapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starssfinanceapp.app.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
