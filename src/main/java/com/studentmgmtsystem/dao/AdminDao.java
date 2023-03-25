package com.studentmgmtsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmgmtsystem.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long>{
	
	Admin findByEmailAndPassword(String email, String password);
}
