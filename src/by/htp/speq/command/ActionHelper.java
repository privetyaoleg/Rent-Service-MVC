package by.htp.speq.command;

import java.io.IOException;

import by.htp.speq.command.impl.AddMoneyClient;
import by.htp.speq.command.impl.DefaultActionImpl;
import by.htp.speq.command.impl.units.GetBackOneUnit;
import by.htp.speq.command.impl.units.GetBackUnitsLogicImpl;
import by.htp.speq.command.impl.units.RentAvaliableUnitImpl;
import by.htp.speq.command.impl.view.ViewByCategory;
import by.htp.speq.command.impl.view.ViewCatalogActionImpl;
import by.htp.speq.command.impl.view.ViewRentedItemsActionImpl;
import by.htp.speq.entity.Category;
import by.htp.speq.view.ConsoleMenu;

public class ActionHelper {
	
	
	public static StationAction defineAction(int input) {
		
		StationAction action = new DefaultActionImpl();
		
		
		switch (input) {
		case 1:
			action = new ViewCatalogActionImpl();
			break;
		
		case 2:
			action = new ViewRentedItemsActionImpl();
			break;
			
		case 3:
			action = new RentAvaliableUnitImpl();
			break;
			
		case 4:
			action = new GetBackUnitsLogicImpl();
			break;
		case 5:
			ConsoleMenu.categoryMenu();
			action = new ViewByCategory(categoryAction());
			break;
			
		case 6:
			action = new AddMoneyClient();
			break;
		
		case 7:
			action = new GetBackOneUnit();
			break;
			
		case 8:
			System.out.println("Good bye! :)");
			System.exit(0);
			break;
			
		

		default:
			break;
		}
		return action;
	}
	
	
	
	public static Category categoryAction(){
		
		try {
			
			int category = ConsoleMenu.readUserInput();
			
			if (category == 1){
				return Category.WINTER;
			} else if (category == 2){
				return Category.ACTIVE;
			} else if (category == 3){
				return Category.SWIMMING;
			} else if (category == 4){
				return Category.CONSOLE;
			} else if (category == 5){
				return Category.CAMERA;
			} else {
				return Category.CARS;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	

}
