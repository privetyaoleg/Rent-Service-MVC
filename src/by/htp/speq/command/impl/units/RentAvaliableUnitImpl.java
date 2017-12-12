package by.htp.speq.command.impl.units;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;

import by.htp.client.Client;

import by.htp.speq.command.StationAction;
import by.htp.speq.entity.Equipment;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.entity.RentedUnit;
import by.htp.speq.logic.read.StationLogic;
import by.htp.speq.logic.read.file.FileRentedCatalogLogicImpl;
import by.htp.speq.logic.read.file.FileStationLogicImpl;
import by.htp.speq.logic.write.FileWriteAvailableCat;
import by.htp.speq.logic.write.FileWriteRentedCat;
import by.htp.speq.logic.write.StationLogicWrite;
import by.htp.speq.logic.write.WriteCatalogsFile;
import by.htp.speq.station.AvaliableCatalog;
import by.htp.speq.station.Catalog;
import by.htp.speq.station.RentedCatalog;
import by.htp.speq.view.ConsoleMenu;
import by.htp.speq.view2.Viewable;
import by.htp.speq.view2.impl.AvailableCatalogView;
import by.htp.speq.view2.impl.MaximumItemView;
import by.htp.speq.view2.impl.RentUnitsInfoView;

/**
 * Class performs manipulations with main catalog and rented catalog based on
 * user's choice; This class deletes selected element from the available catalog
 * and adds it in the rented catalog; Writing information in files occurs after
 * performances.
 * 
 * @author Rutski Aleh;
 *
 */

public class RentAvaliableUnitImpl implements StationAction {

	
	private static StationLogic logic = new FileStationLogicImpl();
	RentUnitsInfoView viewInfo = new RentUnitsInfoView();

	@Override
	public Viewable performAction(Client client) {
	
		System.out.println("Enter number of item: ");

		Set<Integer> temp = readUserInput();

		for (Integer integer : temp) {

			int numItem = integer;

			Catalog catalog = logic.readCatalog();

			if (catalog.getMainCatalog().size() >= numItem && numItem >= 0 ) {
				
				if(RentedCatalog.getRentedCatalog().size() == 4){
					return new MaximumItemView();
				}
			
				RentUnit z = (RentUnit) AvaliableCatalog.getAvCatalog().get(numItem);
				z.setDate(LocalDateTime.now(ZoneId.of("Europe/Minsk")));
				
				checkClientMoney(client, z, numItem);
				

			} else {
				viewInfo.addListError(numItem);
			}
		}

		WriteCatalogsFile.writeFile();
		return viewInfo;

	}
	
	
	private void checkClientMoney(Client client, RentUnit z, int numItem){
		
		if (client.getMoney() >= z.getHourRate()) {

			RentedCatalog.getRentedCatalog().add(z);

			AvaliableCatalog.getAvCatalog().remove(numItem);
			client.minusMoney(z.getHourRate());

			viewInfo.addListSuccess(numItem);

		} else {
			System.out.println("You don't have enough money! Deposit your balance!");
		}
		
	}

	public static Set<Integer> readUserInput() {

		String[] input = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = br.readLine().split("\\s");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return convertInputString(input);

	}

	private static Set<Integer> convertInputString(String[] input) {

		TreeSet<Integer> temp1 = new TreeSet<>();

		for (int i = 0; i < input.length; i++) {
			temp1.add(Integer.valueOf(input[i].trim()) - 1);
		}

		Set<Integer> temp = temp1.descendingSet();

		return temp;
	}

}
