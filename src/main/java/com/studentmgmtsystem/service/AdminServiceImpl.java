package com.studentmgmtsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmgmtsystem.dao.AdminDao;
import com.studentmgmtsystem.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

//	public AdminServiceImpl(AdminDao adminDao) {
//		super();
//		this.adminDao = adminDao;
//	}


	@Override
	public Admin saveAdmin(Admin admin) {
		return adminDao.save(admin);
	}

}
