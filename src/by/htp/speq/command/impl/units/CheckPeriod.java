package by.htp.speq.command.impl.units;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.ZoneId;

import by.htp.client.Client;
import by.htp.speq.command.CheckClient;
import by.htp.speq.command.StationAction;
import by.htp.speq.entity.RentUnit;
import by.htp.speq.station.RentedCatalog;
import by.htp.speq.view2.Viewable;
import by.htp.speq.view2.impl.FinalPeriodView;

public class CheckPeriod implements StationAction {
	
	private int num;
	private Client client;
	private boolean result = false;
	
	

	public CheckPeriod(int num, Client client) {
		super();
		this.num = num;
		this.client = client;
	}


	@Override
	public Viewable performAction(Client client) throws FileNotFoundException {
		
		RentUnit unit = (RentUnit)RentedCatalog.getRentedCatalog().get(num - 1);
		
		int period = CheckClient.useHours(unit.getDate(), LocalDateTime.now(ZoneId.of("Europe/Minsk")));
		double extraPay = 0;
		
		if (period > 1){
			extraPay = period * unit.getHourRate();
			client.minusMoney(extraPay);
			result = true;
		}
		
		return new FinalPeriodView(unit.getTitle(), period, extraPay, result);
	}

}
