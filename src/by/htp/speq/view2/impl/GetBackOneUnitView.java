package by.htp.speq.view2.impl;

import by.htp.client.Client;
import by.htp.speq.view2.Viewable;

public class GetBackOneUnitView implements Viewable{

	private int numUnit;
	private boolean result;
	
	
	public GetBackOneUnitView(int numUnit, boolean result) {
		super();
		this.numUnit = numUnit;
		this.result = result;
	}


	@Override
	public void generateOutput(Client client) {
		if (result == true){
			System.out.printf("Item ¹%d was successfully gotten back!", numUnit);
		} else {
			System.err.println("\nYou don't have such kind of item!");
		}
		
	}

}
