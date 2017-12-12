package by.htp.speq.view2.impl;

import java.time.format.DateTimeFormatter;

import by.htp.client.Client;

import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.RentedCatalog;
import by.htp.speq.view2.Viewable;

public class RentedCatalogView implements Viewable {

	@Override
	public void generateOutput(Client client) {
		
		if (RentedCatalog.getRentedCatalog().size() == 0){
			System.out.println("Your list is empty");
		}
		int count = 0 ;
		double sum = 0;
		for(Equipment cal : RentedCatalog.getRentedCatalog()){
			
			RentUnit ru = (RentUnit)cal;
			DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy.MM.dd - HH:mm:ss");
			
			System.out.printf("%n* * * Item %d: %s, price per hour: %4.2f$ %nwas taken in rent:  %s %n", 
					++count, ru.getTitle(), ru.getHourRate(),ru.getDate().format(date));
			
			sum+=ru.getHourRate();
			
		}
		System.out.printf("Total: %d items, 		total amount: %4.2f$", count, sum);
		
	}
	
	

}
