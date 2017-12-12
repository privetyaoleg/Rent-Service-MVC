package by.htp.speq.command.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import by.htp.client.Client;
import by.htp.speq.command.StationAction;
import by.htp.speq.view.ConsoleMenu;
import by.htp.speq.view2.Viewable;
import by.htp.speq.view2.impl.AddMoneyView;

public class AddMoneyClient implements StationAction{
	
	

	@Override
	public Viewable performAction(Client client) throws FileNotFoundException {
		boolean result = false;
		try {
			System.out.print("Enter sum of money: ");
			int money = ConsoleMenu.readUserInput();
			if (money > 0){
				client.addMoney(money);
				result = true;
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return new AddMoneyView(result);
	}

}
