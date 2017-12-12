package by.htp.speq.logic.read.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.htp.speq.entity.Category;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.station.Catalog;

public class FileStationLogicImpl implements StationLogic{
	
	
	private static final String FILE_PATH = "resources/station_info.txt";
	private static final String DELIMETER = ",";



	@Override
	public Catalog readCatalog(){
		
		Catalog catalog = new Catalog();
		String[] temp = new String[3];
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
	
			String line;
		
			while ((line = br.readLine()) != null) {	
					temp = line.split(DELIMETER);
					catalog.getMainCatalog().add
					(new RentUnit(temp[0].trim(), Double.valueOf(temp[1].trim()), Category.valueOf(temp[2].trim())));			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return catalog;	
	}
	

	
	
}
