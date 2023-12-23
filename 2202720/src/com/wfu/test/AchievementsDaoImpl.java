package com.wfu.test;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import entity.Achievements;

public class AchievementsDaoImpl implements AchievementsDao{
	DBUtil db =new DBUtil();
    public AchievementsDaoImpl() {
    	db.getConn();
    }

	@Override
	public boolean addAchievements(Achievements achievements) throws Exception {
		String sql="insert into achievements(name,time,site,summary) values (?,?,?,?)";
		String[] param= {achievements.getName(),achievements.getTime()+"",
			achievements.getSite(),achievements.getSummary()};
		int x=db.executeUpdate(sql, param);
		return x>0;

	}

	@Override
	public boolean updateAchievements(Achievements achievements) throws Exception {
		String sql ="update achievements set name=?,time=?,site=?,summary=? where id=?";
		String[] param= {achievements.getName(),achievements.getTime()+"",
			achievements.getSite(),achievements.getSummary(),achievements.getId()+""};
		int x=db.executeUpdate(sql, param);
		return x>0;
	}


	@Override
	public boolean deleteAchievements(int id) throws Exception {
		String sql="delete from achievements where id=?";
		String[] param= {id+""};
		int x=db.executeUpdate(sql, param);
		return x>0;
	}


	@Override
	public Achievements getAchievementsById(int id) throws Exception {
		Achievements achievements=null;
		String sql="select * from  achievements  where id=?";
		String[] param= {id+""};
		ResultSet rs=db.executeQuery(sql, param);
		if(rs.next()) {
			achievements=new Achievements();
			achievements.setId(rs.getInt(1));
			achievements.setName(rs.getString(2));			
			achievements.setTime(rs.getString(3));
			achievements.setSite(rs.getString(4));
			achievements.setSummary(rs.getString(5));			
		}
		return achievements;
	}


	@Override
	public List<Achievements> getAllAchievements() throws Exception {
		List<Achievements> list=new ArrayList<Achievements>();
		String sql="select * from achievements";
		String[] param= {};
		ResultSet rs=db.executeQuery(sql, param);
		while(rs.next()) {
			Achievements achievements=new Achievements();
			achievements.setId(rs.getInt(1));
			achievements.setName(rs.getString(2));			
			achievements.setTime(rs.getString(3));
			achievements.setSite(rs.getString(4));
			achievements.setSummary(rs.getString(5));				
			list.add(achievements);
		}
		return list;
	}

}
