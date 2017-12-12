package by.htp.speq.logic.write;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.entity.RentedUnit;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.logic.read.file.FileStationLogicImpl;
import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.Catalog;
import by.htp.speq.station.RentedCatalog;

public class FileWriteAvailableCat implements StationLogicWrite {
	
	private static final String FILE_PATH = "resources/station_info.txt";
	
	
	@Override
	public void writeFile(List<Equipment> list) {
		
		BufferedWriter br;
		try {
			br = new BufferedWriter(new FileWriter(FILE_PATH));
		
			for (Equipment equipment : list) {
				RentUnit unit = (RentUnit)equipment;
				br.write(unit.getTitle() + " , " + unit.getHourRate() + " , " + unit.getCategory() + "\n");
			}
			br.flush();
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
