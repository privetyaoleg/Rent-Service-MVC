package by.htp.speq.command.impl.units;

import java.io.FileNotFoundException;

import by.htp.client.Client;
import by.htp.speq.command.StationAction;
import by.htp.speq.logic.write.FileWriteAvailableCat;
import by.htp.speq.logic.write.FileWriteRentedCat;
import by.htp.speq.logic.write.StationLogicWrite;
import by.htp.speq.logic.write.WriteCatalogsFile;
import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.RentedCatalog;
import by.htp.speq.view2.Viewable;
import by.htp.speq.view2.impl.GetBackAllUnitsView;


/**
 * Class transfer all elements from the rented catalog to available catalog;
 * Writing information in files occurs after performances.
 * 
 * @author Rutski Aleh;
 *
 */

public class GetBackUnitsLogicImpl implements StationAction{

		
		static StationLogicWrite logic;
		GetBackAllUnitsView view = new GetBackAllUnitsView(false);
		
	
		@Override
		public Viewable performAction(Client client) throws FileNotFoundException {
			
			if (RentedCatalog.getRentedCatalog().size() > 0){
				AvaliableCatalog.getAvCatalog().addAll(RentedCatalog.getRentedCatalog());
				RentedCatalog.getRentedCatalog().clear();
				view = new GetBackAllUnitsView(true);		
			} 
			
			WriteCatalogsFile.writeFile();
			return view;
		
		}

}
