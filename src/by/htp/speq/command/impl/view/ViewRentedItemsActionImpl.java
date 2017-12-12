package by.htp.speq.command.impl.view;

import by.htp.client.Client;
import by.htp.speq.command.StationAction;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.view2.Viewable;
import by.htp.speq.view2.impl.RentedCatalogView;

public class ViewRentedItemsActionImpl implements StationAction {

private StationLogic logic;
	
	{
	// logic =  new ConsoleStationLogicImpl();
	// logic = new FileStationLogicImpl();
	// logic = new DataBaseStationImpl();
	}

	
	@Override
	public Viewable performAction(Client client) {
		
		return new RentedCatalogView();
	}
}
