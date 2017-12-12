package by.htp.speq.view2.impl;

import by.htp.client.Client;
import by.htp.speq.view2.Viewable;

public class AddMoneyView implements Viewable {
	
	boolean result;
	

	public AddMoneyView(boolean result) {
		this.result = result;
	}


	@Override
	public void generateOutput(Client client) {
		
		if (result == true){
			System.out.println("Operation was successfully completed!");
		} else {
			System.err.println("ERROR! Check the correctness of the entered data!\n");
		}
		
		
		
	}

}
