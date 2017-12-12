package by.htp.speq.command.impl.view;
import java.io.FileNotFoundException;

import by.htp.client.Client;
import by.htp.speq.command.StationAction;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.logic.read.console.ConsoleStationLogicImpl;
import by.htp.speq.logic.read.file.FileStationLogicImpl;
import by.htp.speq.logic.read.xml.dom.ReadCatalogDOMImpl;
import by.htp.speq.logic.read.xml.sax.ReadCatalogSAXImpl;
import by.htp.speq.station.Catalog;
import by.htp.speq.view2.Viewable;
import by.htp.speq.view2.impl.AvailableCatalogView;

public class ViewCatalogActionImpl implements StationAction{
	
//	private StationLogic logic = new FileStationLogicImpl();
//	private StationLogic logic = new ReadCatalogSAXImpl();
	private StationLogic logic = new ReadCatalogDOMImpl();

	
	{
	// logic =  new ConsoleStationLogicImpl();
	//  logic = new FileStationLogicImpl();
	// logic = new DataBaseStationImpl();
	}

	
	@Override
	public Viewable performAction(Client client) throws FileNotFoundException {
		
		Catalog catalog = logic.readCatalog();
		return new AvailableCatalogView(catalog, client);

	}

}
