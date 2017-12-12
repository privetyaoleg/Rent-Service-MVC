package by.htp.speq.station;

import java.util.ArrayList;

import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.entity.RentedUnit;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.logic.read.file.FileRentedCatalogLogicImpl;
import by.htp.speq.logic.read.file.FileStationLogicImpl;

public class RentedCatalog extends Catalog{

	
	private static ArrayList<Equipment> rentedCatalog = new ArrayList<>();

//	static	{
//		StationLogic logic = new FileRentedCatalogLogicImpl();
//		rentedCatalog = logic.readCatalog().getMainCatalog();	
//	}
	
	public static ArrayList<Equipment> getRentedCatalog() {
		return rentedCatalog;
	}

}
