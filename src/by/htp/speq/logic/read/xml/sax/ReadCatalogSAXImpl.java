package by.htp.speq.logic.read.xml.sax;


import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.speq.command.StationAction;
import by.htp.speq.entity.Equipment;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.Catalog;



public class ReadCatalogSAXImpl implements StationLogic {
	
	private static final String XML_FILE_PATH = "resources/rent_station.xml";

	@Override
	public Catalog readCatalog() {
		
		Catalog catalog = new Catalog();
		try {
			CatalogDataHandler handler = new CatalogDataHandler();
			
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
			reader.parse(XML_FILE_PATH);
			
			List<Equipment> equipments = handler.getEquipments();
			catalog.getMainCatalog().addAll(equipments);
			
			
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
			
		
		return catalog;
		
	}

}