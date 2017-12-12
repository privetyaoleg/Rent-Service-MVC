package by.htp.speq.command;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import by.htp.client.Client;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.RentedCatalog;

public class CheckClient {
	
	
	public static boolean inAvailableList(Client client, int num){
		if (num <= AvaliableCatalog.getAvCatalog().size()){
			return false;
		}
		return true;
	}
	
	public static boolean inRentList(int num){
		if (num <= RentedCatalog.getRentedCatalog().size() && num >= 0){
			return true;
		}
		return false;
	}
	
	public static boolean moneyClient(Client client, int num){
		RentUnit unit = (RentUnit)AvaliableCatalog.getAvCatalog().get(num);
		if(client.getMoney() <= unit.getHourRate()){
			return false;
		}
		return true;	
	}
	
	public static boolean hasMaxItems(){
		if (RentedCatalog.getRentedCatalog().size() != 4){
			return false;
		}
		return true;
	}
	
	public static int useHours(LocalDateTime dateStart, LocalDateTime dateFinish){
		
		int period = (int) ChronoUnit.SECONDS.between(dateStart, dateFinish);
		return period;
		
	}

}
