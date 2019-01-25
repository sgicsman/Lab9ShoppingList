import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map;

public class Lab9ShoppingList {
	
	private static Map<String, Double> menu = new TreeMap<>(); //declaring a variable outside the main method makes it available to ALL methods
	
	static ArrayList<String> userOrder = new ArrayList<>();
	static ArrayList<Double> userBill = new ArrayList<>();

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		populateMenu();
		printMenu();
		
		boolean continueCmd = true; // take order input from user
		
		while (continueCmd) {

			System.out.println("What item would you like to order?");
			String userSelection = scnr.nextLine();
			
			if ( menu.containsKey(userSelection) ) {
				System.out.println("Adding " + userSelection + " to cart at $" + menu.get(userSelection) );
				
				//adding order date (item & price) to parallel arrays in order to compute bill data and display final order
				userOrder.add(userSelection);
				userBill.add( menu.get(userSelection) );
				System.out.println();
				
			} else { System.out.println("Sorry, that item is not on our menu today.");
			}
			String userPrompt1 = "Would you like to order another item? Please enter \"yes\" or \"no\".";
			String userDecision = Validator.getStringMatchingRegex(scnr, userPrompt1, "(yes)|(no)");
			
			if (! ( userDecision.contentEquals("yes") ) ) {
				break;
			}
			
		} // end of while loop
		
		displayOrder(); //display list of items ordered + prices, in columns
		//display average price of items ordered
		
	}
	
	private static void displayOrder() {
		System.out.println("\nPlease check your order: \n");
		
		System.out.printf("%-14s %-14s\n", "Item", "Price");
		
		for (int i = 0; i < 20; i++) {
		System.out.print("_");
		}
		System.out.println();
		for (int j = 0; j <= userOrder.size() -1; j++) {
			System.out.printf( "%-15s %-15s\n", userOrder.get(j), userBill.get(j) );
		}
	}

	
	private static void populateMenu() {
		menu.put("apple", 0.99);
		menu.put("banana", 0.59);
		menu.put("cauliflower", 1.59);
		menu.put("dragonfruit", 2.19);
		menu.put("Elderberry", 1.79);
		menu.put("figs", 2.09);
		menu.put("grapefruit", 1.99);
		menu.put("honeydew", 3.49);
	}
	
	private static void printMenu() {
		System.out.println("Welcome to George's Market!\n");
		
		System.out.printf("%-14s %-14s\n", "Item", "Price");
		
		for (int i = 0; i < 20; i++) {
		System.out.print("_");
		}
		System.out.println();
		for (String name : menu.keySet()) {
			System.out.printf("%-15s %-15s\n", name, menu.get(name));
		}
	}

}