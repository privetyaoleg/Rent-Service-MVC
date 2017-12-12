package by.htp.speq.logic.read.xml.sax;
import static by.htp.speq.logic.read.xml.DataTypeTransformUtil.*;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.speq.entity.Category;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.read.xml.CatalogTagName;


public final class CatalogDataHandler extends DefaultHandler {

	private RentUnit eq;
	private StringBuilder text;
	private List<Equipment> equipments = new ArrayList<>();
	
	private static final char UNDERSCORE = '_';
	private static final char DASH = '-';
	private static final String ID = "id";
	
	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		CatalogTagName tag = getTag(localName);
		switch (tag) {
		case EQUIPMENT:
			eq = new RentUnit();
			String id = attributes.getValue(ID);
			eq.setId(convertId(id));
			break;
			
			
		default:
			break;
		}
		text = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		CatalogTagName tag = getTag(localName);
		switch (tag) {

		case EQUIPMENT:
			equipments.add(eq);
			break;
		case TITLE:
			eq.setTitle(text.toString().trim());
			break;
		case PRICE:
			String price = text.toString().trim();
			eq.setHourRate(convertPrice(price));
			break;
		case CATEGORY:
			String categoryString = text.toString().trim();
			eq.setCategory(Category.valueOf(categoryString));
			break;
		default:
			break;
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch, start, length);
	}
	
	private CatalogTagName getTag(String localName){
		String tag = localName.toUpperCase().replace(DASH, UNDERSCORE);
		CatalogTagName tagElement = CatalogTagName.valueOf(tag);
		return tagElement;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}


}