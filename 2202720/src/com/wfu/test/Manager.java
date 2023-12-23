package com.wfu.test;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import entity.Achievements;
import entity.User;

public class Manager {
	Scanner sc=new Scanner(System. in);
	UserDaoImpl uDao=new UserDaoImpl();
	AchievementsDaoImpl aDao=new AchievementsDaoImpl();
	public static void main(String[] args) throws Exception {
	    Manager m=new Manager();
	    m. preView();
	}
	public void preView() throws Exception {
	    System.out.println("\t\t-------欢迎进入中国航天展示系统-------");
	    System.out.println("请选择以下操作: ");
	    System.out.println("1.登录");
	    System.out.println("2.注册");
	    System.out.println("3.退出");
	    int op=sc.nextInt();
	    switch(op) {
	    case 1:{login();break;}
	    case 2:{regist();break;}
	    case 3:{
	        System.out.println("您已退出该系统");
	        System.exit(0);
	    }
	    }
	}
	public void login() throws Exception {
	    System.out.println("请输入用户名: ");
	    String name=sc.next();
	    System.out.println("请输入密码: ");
	    String password=sc.next();
	    User user=uDao.getByNameAndPassword(name, password);
	    if(user==null) {
	        System.out.println("用户名或密码错误");
            preView();
	    }
	    else {
	    	achievementsView();
	    }
	}
	public void regist() throws Exception{
		String name;
	    while(true) {
	    	System.out.println("请输入用户名:");
	        name=sc.next();
	        boolean f=uDao.getByName(name);
	        if(f==false) break;
	        else {
	        	System.out.println("用户名已存在，请重试");
	        }
	    }    
	    System.out.println("请输入密码: ");
	    String password=sc.next();
	    User user=new User();
	    user.setName(name);
	    user.setPassword(password);
	    int x=uDao.addUser(user);
	    if(x>0) {
	    	System.out.println("注册成功");
	    	preView();
	    }
	    else {
	    	System.out.println("注册失败");
	    }
    }
	public void achievementsView() throws Exception {
		System.out.println("\t\t-------欢迎进入中国航天展示系统-------");
	    System.out.println("请选择以下操作: ");
	    System.out.println("1.查询所有信息");
	    System.out.println("2.根据id查询信息");
	    System.out.println("3.添加信息");
	    System.out.println("4.修改信息");
	    System.out.println("5.删除信息");
	    System.out.println("6.返回");
	    int op=sc.nextInt();
	    switch(op) {
	    case 1:{findAll();break;}
        case 2:{findByid();break;}
        case 3:{add();break;}
	    case 4:{update();break;}
	    case 5:{delete();break;}
	    case 6:preView();
	    }
	    if(op!=6) {
	    	achievementsView();
	    }
	}
		
	
	public void findAll() throws Exception {
		AchievementsDaoImpl dao = new AchievementsDaoImpl();
		List<Achievements> list = dao.getAllAchievements();
		for(Achievements a:list) {
		  try {
	System.out.println(a.getId()+"\t"+a.getName()+"\t"+a.getTime()+"\t"+a.getSite()+"\t"+a.getSummary());
	    }catch (Exception e) {	        
	     e.printStackTrace(); 
	    }
	}
	}	
	public void findByid() throws Exception {
		System.out.println("请输入要查询的id：");
		int id=sc.nextInt();
		Achievements a=aDao.getAchievementsById(id);
		if(a!=null) {
			System.out.println(a.getId()+"\t"+a.getName()+"\t"+a.getTime()+"\t"+a.getSite()+"\t"+a.getSummary());
		}
		else {
			System.out.println("没有查询到指定的信息");
		}
	}
	public boolean add() throws Exception {
	    try {	
	        System.out.println("请输入信息：");
	        System.out.println("id：");
	        int id=sc.nextInt();
	        System.out.println("name：");
	        String name=sc.next();
	        System.out.println("time(需符合YYYY-MM-DD格式)：");
	        String time=sc.next();
	        System.out.println("site：");
	        String site=sc.next();
	        System.out.println("summary：");
	        String summary=sc.next();
	        Achievements newAchievements = new Achievements(id, name, time, site, summary);
	        boolean x=aDao.addAchievements(newAchievements);
	        if(x) { 
	            System.out.println("添加成功");	            
	        }
	        else {
	            System.out.println("添加失败");
	        }
	        return x;
	    } catch (InputMismatchException e) {
	        System.out.println("输入错误，请重新输入");
	        return false;
	    } 
	}	
	public boolean update() throws Exception{	
		try {	
	        System.out.println("请输入要修改的成就的id: ");
	        int id = sc.nextInt();
	        System.out.println("请输入修改后的成就信息: ");
	        System.out.println("名称: ");
	        String name = sc.next();
	        System.out.println("时间(需符合YYYY-MM-DD格式): ");
	        String time = sc.next();
	        System.out.println("地点: ");
	        String site = sc.next();
	        System.out.println("总结: ");
	        String summary = sc.next();
	        Achievements achievements = new Achievements();
			achievements.setId(id);
	        achievements.setName(name); 
	        achievements.setTime(time);
	        achievements.setSite(site);
	        achievements.setSummary(summary);
	        boolean x = aDao.updateAchievements(achievements);
	        if(x) {
	            System.out.println("成就修改成功!");
	        }
	        else {
	            System.out.println("成就修改失败! ");
	        }
	        return x;
	    } catch (InputMismatchException e) {
	        System.out.println("输入错误，请重新输入");
	        return false;
	    } 
	}	

    public boolean delete() throws Exception {		    	
    	    try {
    	        System.out.println("请输入要删除的成就的id: ");
    	        int id = sc.nextInt();
    	        boolean x = aDao.deleteAchievements(id);
    	        if(x) {
    	            System.out.println("成就删除成功!");
    	        }
    	        else {
    	            System.out.println("成就删除失败! ");
    	        }
    	        return x;
    	    } catch (InputMismatchException e) {
    	        System.out.println("输入错误，请重新输入");
    	        return false;
    	    }
    	}
    }

     


