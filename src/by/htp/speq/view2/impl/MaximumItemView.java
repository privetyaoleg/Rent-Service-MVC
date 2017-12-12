package by.htp.speq.view2.impl;

import by.htp.client.Client;
import by.htp.speq.view2.Viewable;

public class MaximumItemView implements Viewable {

	@Override
	public void generateOutput(Client client) {
		System.err.println("You have maximum items! You can rent only 4 items simultaneously!");
		
	}

}
