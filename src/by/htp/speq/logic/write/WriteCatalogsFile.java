package by.htp.speq.logic.write;

import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.RentedCatalog;

public class WriteCatalogsFile {
	
	private static StationLogicWrite logic;
	/**
	 * This method writes information about two catalogs in files.
	 * rented_units.txt - for rented catalog; station_info.txt - for available
	 * catalog;
	 */
	public static void writeFile(){
		
		logic = new FileWriteAvailableCat();
		logic.writeFile(AvaliableCatalog.getAvCatalog());
		
		logic = new FileWriteRentedCat();
		logic.writeFile(RentedCatalog.getRentedCatalog());
	
	}

}
