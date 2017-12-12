package by.htp.speq.view2.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.client.Client;
import by.htp.speq.entity.Accessory;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.Catalog;
import by.htp.speq.view2.Viewable;

public class AvailableCatalogView implements Viewable{

	private Catalog catalog;
	private Client client;
	

	public AvailableCatalogView(Catalog catalog, Client client) {
		super();
		this.catalog = catalog;
		this.client = client;
	}

	@Override
	public void generateOutput(Client client) {
		
			int count = 0 ;
			if(catalog.getMainCatalog().size() == 0){
				System.out.println("EMPTY!");
			}
			for(Equipment cal : catalog.getMainCatalog()){
				RentUnit ru = (RentUnit)cal;
				
				System.out.printf("\n * Item %d: %s, price per hour: %4.2f$ %n ", ++count, ru.getTitle(), ru.getHourRate());
				
				List<Accessory> accesory = ru.getAddition();
				for (Accessory accesory2 : accesory) {
					System.out.println(accesory2);
				}
		
			}
		
	}

}
