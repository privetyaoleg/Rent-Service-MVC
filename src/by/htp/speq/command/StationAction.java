package by.htp.speq.command;

import java.io.FileNotFoundException;

import by.htp.client.Client;
import by.htp.speq.view2.Viewable;

public interface StationAction {
	
	Viewable performAction(Client client) throws FileNotFoundException;

}
