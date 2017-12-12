package by.htp.speq.view2.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import by.htp.client.Client;
import by.htp.speq.view2.Viewable;

public class RentUnitsInfoView implements Viewable {
	
	private List<Integer> numSuccess = new ArrayList<>();
	private List<Integer> numError = new ArrayList<>();

	

	@Override
	public void generateOutput(Client client) {
	
		for (Integer unit : numSuccess) {
			System.out.println("* * Item ¹"+ (unit + 1) + " was added successfully! * *");
		}
		
		for (Integer integer : numError) {
			System.err.printf("Error! Item %d doesn't exist or you don't have enough money!%n", integer+1);
		}
		
		
	}
	
	
	public void addList(Collection<Integer> numOfUnits){
		numSuccess.addAll(numOfUnits);
	}
	
	public void addListSuccess(int num){
		numSuccess.add(num);
	}
	
	public void addListError(int num){
		numError.add(num);	
	}

}
