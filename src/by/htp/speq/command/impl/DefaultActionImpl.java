package by.htp.speq.command.impl;

import by.htp.client.Client;
import by.htp.speq.command.StationAction;
import by.htp.speq.view2.Viewable;
import by.htp.speq.view2.impl.DefaultView;

public class DefaultActionImpl implements StationAction{

	
	@Override
	public Viewable performAction(Client client) {	
		
		return new DefaultView();

	}

}
