package by.htp.speq.view2.impl;

import by.htp.client.Client;
import by.htp.speq.entity.Category;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.Catalog;
import by.htp.speq.view2.Viewable;

public class CatalogCategoryView implements Viewable {

	private Category category;
	private Catalog catalog;
	
	
	public CatalogCategoryView(Category category, Catalog catalog) {
		super();
		this.category = category;
		this.catalog = catalog;
	}



	@Override
	public void generateOutput(Client client) {
		
		int count = 0 ;
		System.out.println("* * * Category " + category);

		for(Equipment cal : catalog.getMainCatalog()){
			
			RentUnit ru = (RentUnit)cal;
			
			if (ru.getCategory().equals(category)){
			
				System.out.printf(" * Item %d: %s, price per hour: %4.2f$ %n ", ++count, ru.getTitle(), ru.getHourRate());
			}
		}
		
		if (count == 0){
			System.out.println("There aren't available items!");
		}
	}

}
