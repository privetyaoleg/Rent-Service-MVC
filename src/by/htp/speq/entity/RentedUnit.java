package by.htp.speq.entity;

import java.time.LocalDateTime;

public class RentedUnit extends RentUnit {

	String holder;
	LocalDateTime date;
	
	public RentedUnit(String title, double hourRate, Category category, LocalDateTime date) {
		super(title, hourRate, category);
		this.holder = holder;
		this.date = date;
	}

	public String getHolder() {
		return holder;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
}
