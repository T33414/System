package com.wfu.test;

import java.util.List;

import entity.User;

public interface UserDao {
    public int addUser(User user);  
    public int delUser(int id);
    public int editUser(User user);
    public List<User> getAll();
    public User getById(int id);
    public User getByNameAndPassword(String name,String password);
    public boolean getByName(String name);
}
