package by.htp.speq.logic.write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import by.htp.speq.command.StationAction;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.entity.RentedUnit;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.logic.read.file.FileStationLogicImpl;
import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.Catalog;
import by.htp.speq.station.RentedCatalog;


public class FileWriteRentedCat implements StationLogicWrite {

	private static final String FILE_PATH = "resources/rented_units.txt";
	

	@Override
	public void writeFile(List<Equipment> list) {
	
			BufferedWriter br;
			try {
				br = new BufferedWriter(new FileWriter(FILE_PATH));
				DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
				
				for (Equipment equipment : list) {
					RentUnit unit = (RentUnit)equipment;
					
					br.write(unit.getTitle() + " , " + unit.getHourRate() + " , " + unit.getCategory()  +
							" , " + unit.getDate().format(date) + "\n");
				}
				br.flush();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}
	
	

	

}
