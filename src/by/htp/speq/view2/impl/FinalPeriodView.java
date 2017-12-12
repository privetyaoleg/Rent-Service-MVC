package by.htp.speq.view2.impl;

import by.htp.client.Client;
import by.htp.speq.view2.Viewable;

public class FinalPeriodView implements Viewable {

	private int period;
	private double extraPay;
	private boolean result;
	private String name;
	
	
	
	public FinalPeriodView(String name, int period, double extraPay, boolean result) {
		this.name = name;
		this.period = period;
		this.extraPay = extraPay;
		this.result = result;
	}

	@Override
	public void generateOutput(Client client) {
		
		if (result == true){
		System.out.printf("You used \"%s\" for %d seconds. You have to extra pay: %4.2f $. %n ", name, period, extraPay);
		} else {
			System.out.println("Thanks :)");
		}
		
	}

}
