package by.htp.speq.entity;

public class Accessory {
	
	private int amount;
	private String tittle;
	private Category category;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Accesory [amount=" + amount + ", tittle=" + tittle + ", category=" + category + "]";
	}
	
	

}
