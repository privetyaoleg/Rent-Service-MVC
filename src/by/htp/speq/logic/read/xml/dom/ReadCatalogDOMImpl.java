package by.htp.speq.logic.read.xml.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static by.htp.speq.logic.read.xml.DataTypeTransformUtil.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.speq.entity.Accessory;
import by.htp.speq.entity.Category;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.station.Catalog;

public class ReadCatalogDOMImpl implements StationLogic {

	private static final String XML_FILE_PATH = "resources/rent_station.xml";

	private RentUnit equipment;
	private Accessory accessory;
	private Catalog catalog = new Catalog();
	private Document doc;
	private List<Equipment> list = new ArrayList<Equipment>();

	@Override
	public Catalog readCatalog() {

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			doc = documentBuilder.parse(XML_FILE_PATH);

			List<Equipment> equipments = parseDocument(doc);
			catalog.getMainCatalog().addAll(equipments);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return catalog;
	}

	private List<Equipment> parseDocument(Document document) {

		Element root = document.getDocumentElement();
		NodeList nodeList = document.getElementsByTagName("equipment");

		for (int i = 0; i < nodeList.getLength(); i++) {
			equipment = new RentUnit();
			Element currentNode = (Element) nodeList.item(i);

			equipment.setId(convertId(currentNode.getAttribute("id")));

			Element element = getSingleChild(currentNode, "title");
			String title = element.getTextContent().trim();
			equipment.setTitle(title);

			element = getSingleChild(currentNode, "price");
			String price = element.getTextContent().trim();
			equipment.setHourRate(convertPrice(price));

			element = getSingleChild(currentNode, "category");
			String category = element.getTextContent().trim();
			equipment.setCategory(Category.valueOf(category));

			addAccessory(currentNode, "addition");
			
			
			list.add(equipment);

		}

		return list;

	}
	
	private void addAccessory(Element currentNode, String tag){
		
		NodeList nodeListAddition = currentNode.getElementsByTagName(tag);
		for (int j = 0; j < nodeListAddition.getLength(); j++) {

			accessory = new Accessory();
			Element currentAcNode = (Element) nodeListAddition.item(j);

			accessory.setAmount(convertId(currentAcNode.getAttribute("amount")));
		
			Element elementAc = getSingleChild(currentAcNode, "title");
			String titleAc = elementAc.getTextContent().trim();
			accessory.setTittle(titleAc);

			elementAc = getSingleChild(currentAcNode, "category");
			String categoryString = elementAc.getTextContent().trim();
			accessory.setCategory(Category.valueOf(categoryString));

			equipment.getAddition().add(accessory);
		}
		
	}

	private Element getSingleChild(Element node, String name) {

		NodeList nodeList = node.getElementsByTagName(name);
		Element childElement = (Element) nodeList.item(0);
		return childElement;

	}

}
