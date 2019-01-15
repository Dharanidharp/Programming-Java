
// Importing the required java libraries
import java.util.Scanner;
import java.util.Iterator;

/**
 * Club Stats: The main class that lets the user register to the club, add climbed mountains and get statistics of the entire club and its members
 * @author Dharanidhar
 *@version 1.0
 */

public class ClubStats {
	
	// Initialising variables of classes Club, Mountain and Climber
	static Club club = new Club();
	static Mountain newMountain = null;
	static Climber newClimber = null;
	
	// Initialising scanner to take input from the user
	static Scanner userInput = new Scanner(System.in);
	
	// Initialising an input variable that stores the user input
	static int input;
	
	// Initialising booleans that check the states (active or not active) of the menu and the entire program
	static boolean isMenuActive = true;
	static boolean isProgramTerminated = false;
	
	/**
	 * Main method: Runs the program
	 * Key roles - Displays the initial program introduction
	 */
	public static void main(String[] args) 
	{
		// Using a do-while loop to keep the user returning back to the menu
		do 
		{
			displayIntro();
			input = userInput.nextInt();
			userChoice();
		}
		
		// Checking the input value and the current state of the program
		while(input != 5 && isMenuActive == false && isProgramTerminated == false);
	}
	
	/**
	 * Key roles - Display the introduction and the menu
	 */
	public static void displayIntro() 
	{
		// Displays the initial introduction of the program
		System.out.println("=========================================");
		System.out.println("Welcome to Misty Mountains");
		System.out.println("How may I help you today ?");
		System.out.println("-----------------------------------------");
		System.out.println("1. New climber details");
		System.out.println("2. New mountain details");
		System.out.println("3. Existing climbers");
		System.out.println("4. Statistics of the club members");
		System.out.println("5. Exit");
		System.out.println("==========================================");
		System.out.println("Choose a number (1-5) from the above menu and enter it below: ");
	}
	
	/**
	 * Key roles - Checks the user input and performs an action
	 */
	public static void userChoice() 
	{
		// Checks the user input choice and performs an action
		
		switch (input) 
		{
			case 1: 
				// Run climber details method
				newClimberDetails();
			break;
			
			case 2: 
				// Run mountain method
				newMountainDetails();
			break;
			
			case 3: 
				// Runs existing user method
				existingUser();
			break;
			
			case 4: 
				// Run club details method
				clubDetails();
			break;
			
			case 5: 
				// Terminates the program
				System.out.println("Exit");
				System.out.println("...Program terminated...");
				isProgramTerminated = true;
			break;
			
			default: 
				// Returns the user back to the menu and warns to enter a valid letter
				System.out.println("Please enter a valid option");
				backToMenu();
			break;
		}
	}
	
	/**
	 * Key roles: 
	 * Creates and registers new climbers to the club
	 * Calls methods from the Climber class and the Club class to perform required functions
	 */
	public static void newClimberDetails() 
	{
		// Initialising a scanner for input
		Scanner userInput = new Scanner(System.in);
		
		// Initialising instance variables for climber details (name, age, gender)
		String climberName;
		int climberAge;
		String climberGender;
		
		// Display introduction text
		System.out.println("Climber Menu");
		System.out.println("-----------------------------------------");
		System.out.println("Welcome, here you can register to the club");
		
		// Prompt to enter user name
		System.out.println("Please enter your name below: ");
		// Scan the input from the next line
		climberName = userInput.nextLine();
		
		// Prompt to enter user gender
		System.out.println("Please enter your gender below: ");
		// Scan the input from the next line
		climberGender = userInput.nextLine();
		
		// Prompt to enter user age
		System.out.println("Please enter your age below: ");
		// Scan the input from the next line
		climberAge = userInput.nextInt();
		
		// Create a new user from the constructor class Climber with above entered details
		Climber climber = new Climber(climberName, climberAge, climberGender);
		
		// Stores the created climber into a variable
		newClimber = climber;
		
		// Adds the created climber into the club members list from the club class
		club.addClimber(newClimber);
		
		// Display a successful registration text
		System.out.println("Congratulations " + newClimber.getClimberName() + ". You have been registered to the club");
		
		// Prompt the user to add a mountain
		System.out.println("Do you want to add a mountain ? Press y/n: ");
		
		// Initialise a scanner for the input
		Scanner userInput2 = new Scanner(System.in);
		String choice = userInput2.nextLine();
		
		// Check the user choice and perform an action
		switch (choice) 
		{
			case "y": 
				// Run mountain details method
				newMountainDetails();
			break;
			
			case "n":
				// Returns the user back to the menu
				backToMenu();
			break;
			
			default:
				// Returns the user back to the menu and warns to enter a valid letter
				System.out.println("Please enter a valid option");
				backToMenu();
			break;
		}
	}
	
	/**
	 * Key roles: 
	 * Creates and registers new mountains climbed into the club
	 * Calls methods from the Climber class, the Mountain class and the Club class to perform required functions
	 */
	public static void newMountainDetails() 
	{
		// Initialise a scanner for user input
		Scanner userInput = new Scanner(System.in);
		
		// Initialise instance variables for mountain details (name, height)
		String mountainName;
		int mountainHeight;
		
		// In case of newClimber being empty
		if(newClimber == null) 
		{
			// Prompt the user to register to the club first
			System.out.println("There are no climbers registered in the club. Do you want to register in the club ? Press y/n: ");
			
			// Initialise a scanner variable for user input and store it
			Scanner input = new Scanner(System.in);
			String choice = input.nextLine();
			
			// Check user input and perform an action
			switch(choice) 
			{
			case "y":
				// Run climber details method
				newClimberDetails();
				break;
				
			case "n":
				// Exit the program
				System.out.println("...Program terminated...");
				isProgramTerminated = true;
				break;
				
			default:
				// Returns the user back to the menu and warns to enter a valid letter
				System.out.println("Please enter a valid option");
				backToMenu();
			break;
			}
		}
		
		else
		{
			// Display intro
			System.out.println("Mountain Menu");
			System.out.println("-----------------------------------------");
			System.out.println("Welcome, here you can add a new mountain to the list of the mountains you have climbed");
			
			// Prompt the user to enter the mountain name
			System.out.println("Please enter the name of the mountain you have climbed below: ");
			
			// Store the mountain name into the instance variable
			mountainName = userInput.nextLine();
			
			// Prompt the user to enter the mountain height
			System.out.println("Please enter the height of the mountain you have climbed below: ");
			
			// Store the mountain height into the instance variable
			mountainHeight = userInput.nextInt();
			
			// Create a new mountain from the constructor class Mountain with above entered details
			Mountain mountain = new Mountain(mountainName,mountainHeight);
			
			// Stores the created mountain into a variable
			newMountain = mountain;
			
			// Add the created mountain into the newClimber mountains list by calling method from the Climber class
			newClimber.addMountain(newMountain);
			
			// Calculate the average height climbed by the climber
			newClimber.averageHeight();
			
			// Find the highest mountain climbed by the climber
			newClimber.getHighestMountain();
			
			// Add the created mountain to a master list of all the mountains climbed by the club members
			club.allMountainsClimbed.add(newMountain);
			
			// Display successful entry of the mountain details
			System.out.println("Congratulations " + newClimber.getClimberName() + ". You have added " + newMountain.get_name() + " to the mountains that you have climbed");
			
			// Prompts the user to add another mountain
			addAnotherMountain();
		}
	}
	
	/**
	 * Key roles: 
	 * Prompts the user to add another mountain
	 * Checks whether the user wants to add another mountain or not and re-runs the required methods declared in this class
	 */
	public static void addAnotherMountain() 
	{
		// Display intro
		System.out.println("-----------------------------------------");
		System.out.println("Do you want to add another mountain ? Press y/n: ");
		
		// Initialise a scanner for user input and store
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		// Check the user input and perform an action
		switch(choice) 
		{
		case "y":
			// Run mountain details method
			newMountainDetails();
		break;
		
		case "n":
			// Run climber stats method
			currrentClimberStats();
		break;
		
		default:
			// Returns the user back to the menu and warns to enter a valid letter
			System.out.println("Please enter a valid option");
			backToMenu();
		break;
		}
	}
	
	/**
	 * Key roles: 
	 * Prompts the user if he wants to look at a quick summary of his details and achievements
	 * Checks whether the user wants a summary and re-runs the required methods declared in this class
	 */
	public static void currrentClimberStats() 
	{
		// Display intro
		System.out.println("-----------------------------------------");
		System.out.println("Do you want to view a quick summary of yourself ? Press y/n: ");
		
		// Initialise a scanner for input and store the input into a variable
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		// Check the user input and perform an action
		switch(choice) 
		{
		case "y":
			// Run summary method
			displaySummary();
		break;
		
		case "n":
			// Return the user back to menu
			backToMenu();
		break;
		
		default:
			// Returns the user back to the menu and warns to enter a valid letter
			System.out.println("Please enter a valid option");
			backToMenu();
		break;
		}
	}
	
	/**
	 * Key roles: 
	 * Displays a quick summary about the user
	 * Calls methods from the climber class and runs required action
	 */
	public static void displaySummary() 
	{
		// Display intro
		System.out.println("Climber Summary: ");
		System.out.println("------------------------------");
		
		// Display climber details (name, age, gender) by calling the accessor methods from the Climber class
		System.out.println("Name:" + newClimber.getClimberName() + ", Age:" + newClimber.getClimberAge() + ", Gender:" + newClimber.getClimberGender());
		System.out.println();
		
		// In case of the newMountain variable being empty
		if(newMountain == null) 
		{
			// Prompt the user to add mountains by returning to the main menu
			System.out.println("Currently, you have not added any mountains. To add, choose the 'Mountain menu' ");
			
			// Return the user to the main menu
			backToMenu();
		}
		
		// In case of the presence of an object in newMountain variable
		else 
		{
			// Display intro
			System.out.println("The mountains that you have climbed: ");
			
			// For loop to search through the entire list of the mountains climbed by the climber
			for(int i = 0; i < newClimber.climbedMountains.size(); i++) 
			{
				// Prints all the mountains climbed by the climber by calling the respective accessor methods
				System.out.println("Mount " + newClimber.climbedMountains.get(i).get_name() + " of height " + newClimber.climbedMountains.get(i).get_Height() + " m");
			}
			
			System.out.println();
			
			// Display the highest mountain climbed by the climber by calling the accessor methods
			System.out.println("Highest mountain climbed: " + newClimber.getHighestMountain().get_name() + ", " + newClimber.getHighestMountain().get_Height() + " m");
			
			// Display the average height climbed by the climber by calling the accessor methods
			System.out.println("Total average height climbed by you: " + newClimber.averageHeight() + " m");
			
			// Prompt the user to enter a level to display all the mountains that are greater than that level
			mountainsGreaterThanLevelForCurrentClimber();
		}
	}
	
	/**
	 * Key roles: 
	 * Displays the statistics of the club, the members of the club, the highest mountain climbed, highest average height recorded in the club
	 * Calls methods from the Climber class, the Mountain class and the Club class
	 */ 
	public static void clubDetails() 
	{
		// In case the newClimber variable is empty
		if(newClimber == null) 
		{
			// Prompt the user to register first
			System.out.println("There are no climbers registered in the club. Do you want to register in the club ? Press y/n: ");
			
			// Initialise a scanner for user input and store it
			Scanner input = new Scanner(System.in);
			String choice = input.nextLine();
			
			// Check the user input and perform an action
			switch(choice) 
			{
			case "y":
				// Run climber details method
				newClimberDetails();
				break;
				
			case "n":
				// Returns the user back to the main menu
				backToMenu();
				break;
				
			default:
				// Returns the user back to the menu and warns to enter a valid letter
				System.out.println("Please enter a valid option");
				backToMenu();
			break;
			}
		}
		
		else 
		{
			// Display intro
			System.out.println("Club Statistics");
			System.out.println("-----------------------------------------");
			System.out.println("Club members: ");
			System.out.println("-------------");
			
			// Loop through the entire climber names list
			for(int x = 0; x < club.climberNames.size(); x++) 
			{
				// Display the climber name and the highest mountain climbed by the climber by calling the respective methods
				System.out.println("Name: " + club.climberNames.get(x) + ", Highest mountain: " + club.climbersList.get(x).getHighestMountain().get_name() + " of " + club.climbersList.get(x).getHighestMountain().get_Height() + " m");
			}
			
			/*
			// Go through all the climbers names list and display them
			Iterator<String> iterator = club.climberNames.iterator();
			
			// Perform only when the iterator has a next element
			while(iterator.hasNext()) 
			{
				Object arrayElement = iterator.next();
				
				// Display the all the array objects
				System.out.println(arrayElement);
			}
			*/
			
			// In case of an empty newMountain variable
			if(newMountain == null) 
			{
				// Display intro and prompt to add a new mountain
				System.out.println("-----------------------------------------");
				System.out.println("There seems to be no mountain details in the club. Do you want to add a mountain that you have climbed ? Press y/n: ");
				
				// Initialise a scanner for user input and store it
				Scanner input = new Scanner(System.in);
				String choice = input.nextLine();
				
				// Check user input and perform an action
				switch(choice) 
				{
				case "y":
					// Run mountain details method
					newMountainDetails();
				break;
				
				case "n":
					// Return the user back to the menu
					backToMenu();
				break;
				
				default:
					// Returns the user back to the menu and warns to enter a valid letter
					System.out.println("Please enter a valid option");
					backToMenu();
				break;
				}
			}
			
			else 
			{
				// Display the statistics of the club
				System.out.println("-----------------------------------------");
				System.out.println("Club Statistics: ");
				System.out.println("----------------");
				
				// Display the highest average height climbed in the club by calling the accessor methods
				System.out.println("Highest Average height climbed by: " + club.highestAverageHeight().getClimberName() + " :- " + club.highestAverageHeightRecorded + "m");
				
				// Display the highest mountain climbed in the club by calling the accessor methods
				System.out.println("Highest mountain recorded: " + club.getHighestMountainRecorded().get_name() + " " + club.getHighestMountainRecorded().get_Height() + "m");
				
				// Run level method
				mountainsGreaterThanLevelInClub();
			}
		}
	}
	
	/**
	 * Key roles: 
	 * Prompt the user to enter a level to display all the mountains climbed by the current climber that are greater than that level
	 * Display the introduction
	 * Check whether the user wants to run this action by checking the user input
	 */ 
	public static void mountainsGreaterThanLevelForCurrentClimber() 
	{
		// Display intro
		System.out.println("-----------------------------------------");
		
		// Display prompt
		System.out.println("Do you want to know the climbed mountains that are greater than a certain height ? Press y/n: ");
		
		// Initialise a scanner for user input and store it
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		// Check the user input and perform an action
		switch(choice) 
		{
		case "y":
			// Run the level method
			levelCurrentClimber();
			// Return the user back to the menu
			backToMenu();
		break;
		
		case "n":
			// Return the user back to the menu
			backToMenu();
		break;
		
		default:
			// Returns the user back to the menu and warns to enter a valid letter
			System.out.println("Please enter a valid option");
			mountainsGreaterThanLevelForCurrentClimber();
		break;
		
		}
	}
	
	/**
	 * Key roles: 
	 * Take a level from the user
	 * Takes an input from the user (height)
	 * Runs a method from the Climber class that returns all the mountains that are greater than the entered level
	 */ 
	public static void levelCurrentClimber() 
	{
		// Initialise a scanner for user input
		Scanner input = new Scanner(System.in);
		
		// Display intro
		System.out.println("Enter a number (height) in metres: ");
		
		// Store the entered leve
		int height = input.nextInt();
		
		// Display the list of the mountains by calling the accessor method from the club class
		System.out.println("Mountains greater than " + height + ": " + newClimber.getMountainsHigherThan(height));
	}
	
	/**
	 * Key roles: 
	 * Prompt the user to enter a level to display all the mountains that are greater than that level in the entire club
	 * Display the introduction
	 * Check whether the user wants to run this action by checking the user input
	 */ 
	public static void mountainsGreaterThanLevelInClub() 
	{
		// Display intro
		System.out.println("-----------------------------------------");
		
		// Display prompt
		System.out.println("Do you want to know the climbed mountains that are greater than a certain height ? Press y/n: ");
		
		// Initialise a scanner for user input and store it
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();
		
		// Check the user input and perform an action
		switch(choice) 
		{
		case "y":
			// Run the level method
			level();
			// Return the user back to the menu
			backToMenu();
		break;
		
		case "n":
			// Return the user back to the menu
			backToMenu();
		break;
		
		default:
			// Returns the user back to the menu and warns to enter a valid letter
			System.out.println("Please enter a valid option");
			mountainsGreaterThanLevelInClub();
		break;
		
		}
	}
	
	/**
	 * Key roles: 
	 * Take a level from the user
	 * Takes an input from the user (height)
	 * Runs a method from the Club class that returns all the mountains that are greater than the entered level
	 */ 
	public static void level() 
	{
		// Initialise a scanner for user input
		Scanner input = new Scanner(System.in);
		
		// Display intro
		System.out.println("Enter a number (height) in metres: ");
		
		// Store the entered leve
		int height = input.nextInt();
		
		// Display the list of the mountains by calling the accessor method from the club class
		System.out.println("Mountains greater than " + height + ": " + club.getMountainsHigherThanALevel(height));
	}
	
	/**
	 * Key roles: 
	 * Prompt the user to return back to the main menu
	 * Checks whether the user wants to go back to the main menu
	 * Returns the user to the main menu
	 * Exits the program
	 */ 
	public static void backToMenu() 
	{
		// Initialise a scanner for user input
		Scanner userInput = new Scanner(System.in);
		String userChoice;
		
		// Display the prompt
		System.out.println("-----------------------------------------");
		System.out.println("Return back to the main menu ? Press y/n: ");
		userChoice = userInput.next();
		
		// Check the user input and perform an action
		switch(userChoice) 
		{
		case "y":
			// Toggle isMenuActive boolean
			isMenuActive = false;
			break;
			
		case "n":
			// Exit the program
			System.out.println("...Program terminated...");
			isProgramTerminated = true;
			break;
			
		default:
			// Returns the user back to the menu and warns to enter a valid letter
			System.out.println("Please enter a valid option");
			backToMenu();
		break;
		}
	}
	
	// ======================================================================================================================================================
	// Extra improvements to the program
	/**
	 * Key roles: 
	 * Asks the user if he/she is already registered
	 * Displays all the registered climbers
	 * Prompts the user to select him/her self to open another menu
	 * Allows the climber to add more mountains, display quick summary and statistics
	 */ 
	public static void existingUser() 
	{
		// Prompts the user to tell if he/she is registered
		System.out.println("-----------------------------------------");
		System.out.println("Are u an existing climber ? Press y/n");
		
		// Initialise a scanner for user input
		Scanner userInput = new Scanner(System.in);
		String userChoice;
		
		userChoice = userInput.next();
		
		// Check the user input and perform an action
		switch(userChoice) 
		{
		case "y":
			// Run display registered climbers
			registeredClimbers();
			break;
			
		case "n":
			// Returns the user back to the menu
			backToMenu();
			break;
			
		default:
			// Returns the user back to the menu and warns to enter a valid letter
			System.out.println("Please enter a valid option");
			backToMenu();
		break;
		}
	}
	
	/**
	 * Key roles: 
	 * Displays the names of all the registered users
	 * Prompts the user to select him/her self to open another menu
	 * Allows the registered climber to add more mountains, display quick summary and statistics
	 */ 
	public static void registeredClimbers() 
	{
		// Display the number of climbers registered based on the number of climbers registered
		if(club.climbersList.size() == 1) 
		{
			// In case only 1 climber is registered
			System.out.println("There is currently " + club.climbersList.size() + " climber registered");
			displayRegisteredClimbers();
		}
		
		else if(club.climbersList.size() > 1)
		{
			// In case of more than 1 climbers registered
			System.out.println("There are currently " + club.climbersList.size() + " climbers registered");
			displayRegisteredClimbers();
		}
		
		// If there are no climbers registered
		else if(club.climbersList.size() == 0) 
		{
			System.out.println("There are currently " + club.climbersList.size() + " climbers registered");
			System.out.println("Do you want register to the club ? Press: y/n");
			
			// Initialise a scanner for user input and store it
			Scanner userInput = new Scanner(System.in);
			String userChoice  = userInput.next();
			
			// Check the user input and perform an action
			switch(userChoice) 
			{
			case "y":
				// Run new climber details method
				newClimberDetails();
				break;
				
			case "n":
				// Returns the user back to the menu
				backToMenu();
				break;
				
			default:
				// Returns the user back to the menu and warns to enter a valid letter
				System.out.println("Please enter a valid option");
				backToMenu();
			break;
			}
		}
	}
	
	/**
	 * Key roles: 
	 * Displays the names of all the registered users
	 * Loop through all the climbers in the climbers list
	 * Allows the registered climber to add more mountains, display quick summary and statistics
	 */ 
	public static void displayRegisteredClimbers() 
	{
		// Loop through all the climbers in the climbers list
		for(int i = 0; i < club.climbersList.size(); i++) 
		{
			// Print each climber name
			System.out.println((i + 1) + ". " + club.climbersList.get(i).getClimberName());
		}
		
		// Display instruction
		System.out.println("Choose the number next to your name and enter it: ");
		
		// Initialise a scanner for user input and store it
		Scanner userInput = new Scanner(System.in);
		int userChoice = userInput.nextInt();
		
		// Initialise instance variables
		int x = 0;
		boolean foundClimber = false;
		
		// Loop through the climbers list only when the climber is not found and there are climber present in the list
		while(x < club.climbersList.size() && foundClimber == false) 
		{
			// Compare the user choice with the displayed climber number displayed (example: 1. A, 2. B, 3. C)
			if(userChoice == (x + 1)) 
			{
				// If user choice is present then display the chosen climber
				System.out.println("You have chosen: " + club.climbersList.get(x).getClimberName());
		
				// Toggle found climber to true
				foundClimber = true;
						
				// Set the new climber to the current climber object accessed through the loop
				newClimber = club.climbersList.get(x);
						
				// Display existing climber menu
				System.out.println("-----------------------------------------");
				System.out.println("Welcome back " + club.climbersList.get(x).getClimberName() + ". What would you like to do ?");
				System.out.println("1. Add more mountains");
				System.out.println("2. Summary of you");
				System.out.println("3. Club statistics");
				System.out.println("4. Exit");
				
				// Initialise a scanner for user input and store it 
				Scanner inputEC = new Scanner(System.in);
				
				// EC stands for existing climber
				int ec =  inputEC.nextInt();
				
				// Check the user input and perform an action
				switch(ec) 
				{
					case 1:
						// Run mountain details method
						newMountainDetails();
					break;
					
					case 2:
						// Run display summary method
						displaySummary();
					break;
							
					case 3:
						// Run club details method
						clubDetails();
					break;
							
					case 4:
						// Terminates the program
						System.out.println("Exit");
						System.out.println("...Program terminated...");
						isProgramTerminated = true;
					break;
							
					default:
						// Returns the user back to the menu and warns to enter a valid letter
						System.out.println("Please enter a valid option");
						backToMenu();
					break;
					}
				}
					
			else 
			{
				// In case the climber is not found
				// Toggle found climber to false
				foundClimber = false;
			
				// Increase x by 1
				x++;
			}
		}
	}
}