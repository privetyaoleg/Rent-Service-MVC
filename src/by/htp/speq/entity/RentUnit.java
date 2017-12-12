package by.htp.speq.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RentUnit extends Equipment{
	

	private double hourRate;
	private Category category;
	private LocalDateTime date;
	private List<Accessory> addition = new ArrayList<>();

	public List<Accessory> getAddition() {
		return addition;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public RentUnit(String title, double hourRate, Category category) {
		super(title);
		this.hourRate = hourRate;
		this.category = category;
	}
	
	public RentUnit(String title, double hourRate, Category category, LocalDateTime date) {
		super(title);
		this.hourRate = hourRate;
		this.category = category;
		this.date = date;
	}
	
	public RentUnit(){
		
	}
	
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getHourRate() {
		return hourRate;
	}

	public void setHourRate(double hourRate) {
		this.hourRate = hourRate;
	}


}
