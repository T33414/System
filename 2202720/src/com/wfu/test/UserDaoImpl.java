package com.wfu.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDaoImpl extends DBUtil implements UserDao {

	@Override
	public int addUser(User user) {
		this.getConn();
		String sql="insert into user(name,password) values(?,?)";
		String[] param= {user.getName(),user.getPassword()};
		int x=this.executeUpdate(sql, param);		
		return x;
	}

	@Override
	public int delUser(int id) {
		this.getConn();
		String sql="delete from user where id=?";
		String[] param= {id+""};
		int x=this.executeUpdate(sql, param);
		return x;
	}

	@Override
	public int editUser(User user) {
		this.getConn();
		String sql="update user set namae=?,password=? where id=?";
		String[]param= {user.getName(),user.getPassword(),user.getId()+""};
		int x=this.executeUpdate(sql, param);
		return x;
	}

	@Override
	public List<User> getAll() {
		this.getConn();
		String sql="select * from user";
		String[]param= {};
		ResultSet rs=this.executeQuery(sql, param);
//      遍历结果集，存放到list中
	List<User>list=new ArrayList<>();	
	try {	
		while(rs.next()) {
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			list.add(user);
		}
	}catch (SQLException e) {
		//TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
}

	@Override
	public User getById(int id) {
		this.getConn();
		String sql="select * from user where id=?";
		String[]param= {id+""};
		ResultSet rs=this.executeQuery(sql, param);
		User user=null;
		try {
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		}catch(SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getByNameAndPassword(String name,String password) {
		// TODO Auto-generated method stub
		this.getConn();
		String sql="select * from user where name=? and password=?";
		String[]param= {name,password};
		ResultSet rs=this.executeQuery(sql, param);
		User user=null;
		try {
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		}catch(SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public boolean getByName(String name) {
	    this.getConn();
	    String sql="select * from user where name=?";
	    String[]param= {name};
	    ResultSet rs=this.executeQuery(sql, param);
	    User user=null;
	    boolean f=false;
	    try {
		    if(rs.next()) {
		    	f=true;
		    }    
	    }catch(SQLException e) {
		    //TODO Auto-generated catch block
		    e.printStackTrace();
	    } 
	    return f;
	}
	    
}
