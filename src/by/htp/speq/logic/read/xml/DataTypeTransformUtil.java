package by.htp.speq.logic.read.xml;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTypeTransformUtil {
	
	
	public static int convertId(String id){	
		int idInt = 0;
		try {
			idInt = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			System.out.println("wrong value for id");
			e.printStackTrace();
		}
		return idInt;
	}
	
	
	public static double convertPrice(String price){
		double priceDouble = 0;
		try {
			priceDouble = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			System.out.println("wrong value for price");
			e.printStackTrace();
		}
		return priceDouble;
		
	}
	
	public static Date convertDate(String date){
		Date dateD = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			dateD = sdf.parse(date);
		} catch (Exception e) {
			System.out.println("wrond date format");
		}
		return dateD;
	}
	
	

}
