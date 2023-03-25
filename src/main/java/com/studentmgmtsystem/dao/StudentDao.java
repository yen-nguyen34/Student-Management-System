package com.studentmgmtsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmgmtsystem.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

}
