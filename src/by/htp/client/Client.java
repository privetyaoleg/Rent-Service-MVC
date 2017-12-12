package by.htp.client;

import by.htp.speq.station.RentedCatalog;

public class Client {
	
	private String name;
	private double money;
	

	public Client(String name) {
		this.name = name;
		money = 1000;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getMoney() {
		return money;
	}



	public void setMoney(int money) {
		this.money = money;
	}
	
	
	public void addMoney(double sum){
		money+=sum;
	}
	
	public void minusMoney(double d){
		money-=d;
	}
	
}
