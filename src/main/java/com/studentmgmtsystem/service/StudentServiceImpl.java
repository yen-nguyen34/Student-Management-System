package com.studentmgmtsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmgmtsystem.dao.StudentDao;
import com.studentmgmtsystem.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentDao.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentDao.deleteById(id);
		
	}

}
