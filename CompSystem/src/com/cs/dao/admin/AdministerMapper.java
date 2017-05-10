package com.cs.dao.admin;

import com.cs.pojo.Administer;

public interface AdministerMapper {
	 Administer selectByID(String adminno);
	 String getDepartment(String adminno);
}