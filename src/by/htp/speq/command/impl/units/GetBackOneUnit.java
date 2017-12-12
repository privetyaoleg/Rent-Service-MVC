package by.htp.speq.command.impl.units;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import by.htp.client.Client;
import by.htp.speq.command.CheckClient;
import by.htp.speq.command.StationAction;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.write.WriteCatalogsFile;
import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.RentedCatalog;
import by.htp.speq.view.ConsoleMenu;
import by.htp.speq.view2.Viewable;
import by.htp.speq.view2.impl.GetBackOneUnitView;

public class GetBackOneUnit implements StationAction {

	private int num = 0;
	private boolean result = false;
	private RentUnit unit;
	

	@Override
	public Viewable performAction(Client client) throws FileNotFoundException {

		System.out.print("Enter num of item: ");
		try {
			num = ConsoleMenu.readUserInput();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (result = (CheckClient.inRentList(num))) {
			
			Viewable view = new CheckPeriod(num, client).performAction(client);
			view.generateOutput(client);
			
			AvaliableCatalog.getAvCatalog().add(RentedCatalog.getRentedCatalog().get(num - 1));
			RentedCatalog.getRentedCatalog().remove(num - 1);
		}
		
		

		WriteCatalogsFile.writeFile();
		return new GetBackOneUnitView(num, result);
	}
	
	

}
