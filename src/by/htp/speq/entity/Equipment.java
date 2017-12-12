package by.htp.speq.entity;

public abstract class Equipment {
	
	private String title;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipment(String title) {
		
		this.title = title;
		
	}
	
	public Equipment() {
		
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
	

}
