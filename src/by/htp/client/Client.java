package by.htp.client;

import java.io.Serializable;

import by.htp.speq.station.RentedCatalog;

public class Client implements Serializable{
	
	private final String name;
	private double money;
	

	public Client(String name) {
		this.name = name;
		money = 1000;
	}


	public String getName() {
		return name;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
