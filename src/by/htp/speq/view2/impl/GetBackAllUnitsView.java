package by.htp.speq.view2.impl;

import by.htp.client.Client;
import by.htp.speq.view2.Viewable;

public class GetBackAllUnitsView implements Viewable {
	
	private boolean result = false;

	public GetBackAllUnitsView(boolean result) {
		this.result = result;
	}

	@Override
	public void generateOutput(Client client) {
		
		if (result == true){
			System.out.println("All your items have gotten back to the rent station!");
		} else {
			System.err.println("You don't have any items!");
		}
		
	}
	

}
