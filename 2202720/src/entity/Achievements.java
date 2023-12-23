package entity;

public class Achievements {
	private int id;
	private String name;	
	private String time;
	private String site;
	private String summary;
	public Achievements() {
		super();
	}
	public Achievements(int id,String name,String time,String site, 
        String summary) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.site = site;
		this.summary = summary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {	    	    
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}	
}


