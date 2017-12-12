package by.htp.speq.logic.read.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import by.htp.speq.entity.Category;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.entity.RentedUnit;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.station.Catalog;

public class FileRentedCatalogLogicImpl implements StationLogic {

	private static final String FILE_PATH = "resources/rented_units.txt";
	private static final String DELIMETER = ",";


	@Override
	public Catalog readCatalog(){
		
		Catalog catalog = new Catalog();
		String[] temp = new String[3];
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
			
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
			// LocalDateTime date1 = LocalDateTime.parse("21.05.2016 12:22", formatter);
	
			String line;
		
			while ((line = br.readLine()) != null) {	
					temp = line.split(DELIMETER);
					catalog.getMainCatalog().add
					(new RentUnit(temp[0].trim(), Double.valueOf(temp[1].trim()), Category.valueOf(temp[2].trim())
							,LocalDateTime.parse(temp[3].trim(), formatter)));	
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return catalog;	
	}
	
	
}
