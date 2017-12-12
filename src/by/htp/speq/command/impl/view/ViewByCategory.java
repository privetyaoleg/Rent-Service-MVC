package by.htp.speq.command.impl.view;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import by.htp.client.Client;
import by.htp.speq.command.StationAction;
import by.htp.speq.entity.Category;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.logic.read.file.FileStationLogicImpl;
import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.Catalog;
import by.htp.speq.view2.Viewable;
import by.htp.speq.view2.impl.CatalogCategoryView;

public class ViewByCategory implements StationAction{
	
	private StationLogic logic = new FileStationLogicImpl();
	private Category category;
	
	
	public ViewByCategory(Category category) {
		super();
		this.category = category;
	}

	@Override
	public Viewable performAction(Client client) throws FileNotFoundException {
	
		Catalog catalog = logic.readCatalog();
		
		return new CatalogCategoryView(category, catalog);	
	}

}
