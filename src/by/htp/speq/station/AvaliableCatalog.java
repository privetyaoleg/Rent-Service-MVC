package by.htp.speq.station;

import java.util.ArrayList;
import java.util.List;

import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.logic.read.file.FileStationLogicImpl;
import by.htp.speq.logic.read.xml.dom.ReadCatalogDOMImpl;
import by.htp.speq.logic.read.xml.sax.ReadCatalogSAXImpl;
import by.htp.speq.entity.*;

public class AvaliableCatalog extends Catalog {

	
	private static List<Equipment> avCatalog = new ArrayList<>();
	
	static{
		
//		StationLogic logic = new FileStationLogicImpl();
//		StationLogic logic = new ReadCatalogSAXImpl();
		StationLogic logic = new ReadCatalogDOMImpl();
		
		avCatalog = logic.readCatalog().getMainCatalog();
	}

	public static List<Equipment> getAvCatalog() {
		return avCatalog;
	}

	public static void setAvCatalog(List<Equipment> avCatalog) {
		AvaliableCatalog.avCatalog = avCatalog;
	}
	
}
