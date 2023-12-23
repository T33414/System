package com.wfu.test;

import java.util.List;

import entity.Achievements;

public interface AchievementsDao {	    
	public boolean addAchievements(Achievements achievements) throws Exception;
	public boolean updateAchievements(Achievements achievements) throws Exception;
	public boolean deleteAchievements(int id) throws Exception;
	public Achievements getAchievementsById(int id) throws Exception;
	public List<Achievements> getAllAchievements() throws Exception;
}	


