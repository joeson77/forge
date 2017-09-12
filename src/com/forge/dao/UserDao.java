package com.forge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.forge.entity.User;


public class UserDao extends BaseDao<User> {
	public boolean checkUser(User user){
		List<User> list = executeQuery("select * from user where uname = ? and upassword = ?", new Object[]{user.getUname(),user.getUpassword()});
		return list.size() > 0 ? true:false;
	}
	public boolean checkUserName(User user){
		List<User> list = executeQuery("select * from user where uname = ?", new Object[]{user.getUname()});
		return list.size() > 0 ? true:false;
	}
	public List<User> getAllUser(){
		return super.executeQuery("select * from user");
	}
	public List<User> getUserByPage(int pageSize,int pageNum){
		return super.executeQuery("select * from user2 limit" + pageSize*(pageNum - 1) + "," + pageSize);
	}
	public int getMaxPage(int pageSize){
		int count = super.executeQueryCount("select count(*) from user2");
		return count%pageSize == 0 ? count/pageSize :count/pageSize + 1;
	}
}
