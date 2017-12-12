package by.htp.speq.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.client.Client;
import by.htp.speq.command.ActionHelper;
import by.htp.speq.command.StationAction;
import by.htp.speq.station.RentedCatalog;
import by.htp.speq.view2.Viewable;

public class ConsoleMenu {
	
	/**
	 * Intro menu + rent menu
	 * @throws Exception
	 */
	
	private static Client client;
	
	public static void actionMenu() throws Exception{
		
		client = printIntro();
		
		do {
			
			ConsoleMenu.printMenu();
			StationAction action = ActionHelper.defineAction(ConsoleMenu.readUserInput());
			Viewable view = action.performAction(client);
			view.generateOutput(client);
			} while(true);
	}
	

	public static Client printIntro(){
		
		String userName = "";
		
		do {
			System.out.println("Hello! Please, enter your name: ");
		} while(!correctName(userName = (readUserName())));
		
		StringBuilder sb = new StringBuilder(userName.toLowerCase());
		sb.setCharAt(0, Character.toUpperCase(userName.charAt(0)));
		
		System.out.printf("Welcome, %s!\n", sb.toString());
		
		return createClient(sb.toString());
		

	}
	
	public static Client createClient(String name){
		Client client1 = new Client(name);
		return  client1;	
	}
	
	/**
	 * This method defines whether correct an enter name.
	 * Regex -> Oleg, oleg - true;
	 *          123, oleg123 - false;
	 * 
	 * @param name
	 * @return 
	 */
	
	private static boolean correctName(String name){
		
		Pattern pt = Pattern.compile("[a-zA-Z]{2,10}");
		Matcher m = pt.matcher(name);
		boolean ft = m.matches();
		
		return ft;
	}
	
	
	
	public static String readUserName(){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return name;
	}
	
	public static int readUserInput() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().trim();
		return convertInputString(input);	
	
	}
	
	private static int convertInputString(String input) {
		return Integer.parseInt(input);
	}
	
	
	public static void printMenu() {
		
		System.out.println("\n***************RENT MENU*******************\n");
		System.out.println("1. 	View catalog");
		System.out.println("2. 	View rented catalog.");
		System.out.println("3. 	Rent item.");
		System.out.println("4.	Get back all rented items");
		System.out.println("5.	Search items by category");
		System.out.println("6.	Deposit money");
		System.out.println("7.	Get back one rented item");
		System.out.println("8. 	Exit");
		System.out.println("\n*******************************************");
		
		System.out.printf("Client: %s         	 Balance: %4.2f $%nAmount of item: %d%n", client.getName(), client.getMoney(), 
																					 RentedCatalog.getRentedCatalog().size());
		printCurrentTime();
		System.out.println("*******************************************\n");
	}
	
	public static void printCurrentTime(){
		
		ZoneId minskZone = ZoneId.of("Europe/Minsk");
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy.MM.dd 			HH:mm:ss");
		LocalDateTime currentTime = LocalDateTime.now(minskZone);
		System.out.println(currentTime.format(date));
		
	}
	
	
	
	public static void categoryMenu(){
		System.out.println("\n*************CATEGORY*************\n");
		System.out.println("1. 	Winter");
		System.out.println("2. 	Active");
		System.out.println("3.	Swiming");
		System.out.println("4.	Console");
		System.out.println("5. 	Camera");
		System.out.println("6. 	Cars");
		
	}

}
