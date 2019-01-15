
// Importing the required java libraries
import java.util.ArrayList;

/**
 * Climber: Creates and registers new climbers
 * @author Dharanidhar
 *@version 1.0
 */
public class Climber 
{
	// Initialise instance variables
	private String climberName;
	private int climberAge;
	private String climberGender;
	
	// An array list to store all the mountains climbed by the climber
	public ArrayList<Mountain> climbedMountains = new ArrayList<>();
	
	/**
	 * Key roles:
	 * Constructor for Climber class
	 * Creates a climber with a name, age and gender
	 * @param cName Takes the name of the climber entered by the user and stores it 
	 * @param cAge Takes the age of the climber entered by the user and stores it
	 * @param cGender Takes the gender of the climber entered by the user and stores it
	 */
	public Climber(String cName, int cAge, String cGender) 
	{
		climberName = cName;
		climberAge = cAge;
		climberGender = cGender;
	}
	
	// Accessor method to get current climbers name
	public String getClimberName() 
	{
		return this.climberName;
	}
	
	// Accessor method to get current climbers gender
	public String getClimberGender() 
	{
		return this.climberGender;
	}
	
	// Accessor method to get current climbers age
	public int getClimberAge() 
	{
		return this.climberAge;
	}
	
	// Add the mountain climbed to a list
	public void addMountain(Mountain newMountain) 
	{
		climbedMountains.add(newMountain);
	}
	
	/**
	 * Key roles:
	 * Find the highest mountain climbed by the climber
	 * Looks at the height of mountains climbed by the climber
	 * Stores the height of the first mountain climbed in the list as the highest mountain and then compares it with the height of the current mountain in the list
	 * @return Returns the highest mountain recorded by the climber
	 */
	public Mountain getHighestMountain() 
	{
		// Initialising an index variable for accessing the array elements of climbed mountains
		int index = 0;
		
		// Store the first mountain from the climbed mountains list as the highest mountain
		Mountain highestMountain = climbedMountains.get(index);
		
		// Loop through the climbed mountains list
		while(index < climbedMountains.size()) 
		{
			// Instance of the mountain class to store current mountain object
			Mountain thisMountain = climbedMountains.get(index);
			
			// Compare the height of this mountain with the highest mountain that is stored
			if(thisMountain.get_Height() > highestMountain.get_Height()) 
			{
				// In case the current mountain height is greater, store current mountain as the highest mountain
				highestMountain = thisMountain;
			}
			else 
			{
				// Increase the value of the index by 1
				index++;
			}
		}
		
		return highestMountain;
	}
	
	/**
	 * Key roles:
	 * Find the average height of the climbed mountains
	 * Looks at all the heights of all the mountains climbed by the climber
	 * Adds the heights of the individual mountains and stores them as a sum
	 * Divides the sum by the climbed mountains list to get the average height
	 * @return Returns the average height recorded by the climber
	 */
	public double averageHeight() 
	{
		// Initialising instance variables for sum and the average
		double sumOfHeights = 0;
		double avgOfHeights = 0;
		
		// Loop through the entire climbed mountains list
		for(int i = 0; i < climbedMountains.size(); i++) 
		{
			// Add the current mountains height to the height stored in the sum variable
			sumOfHeights += climbedMountains.get(i).get_Height();
			
			// Divide sum of the heights with the size of the climbedMountains array list and store the value as the average height climbed by the climber
			avgOfHeights = sumOfHeights / climbedMountains.size();
		}
		
		return avgOfHeights;
	}
	
	/**
	 * Key roles:
	 * Display a list of mountains climbed with height greater than a given level
	 * Compares the heights of all the mountains in the list with the level
	 * @param level: Stores a height that is entered by the user
	 * @return Returns the mountain names that are higher than entered level
	 */
	// Display a list of mountains climbed with height greater than a given level
	public ArrayList<String> getMountainsHigherThan(int level) 
	{
		// Create a new array list of mountain names
		ArrayList<String> mountainsList = new ArrayList<>();
		
		for(int i = 0; i < climbedMountains.size(); i++) 
		{
			// Compare the current height of the mountain in the climbed mountains list with the level entered
			if(climbedMountains.get(i).get_Height() > level) 
			{
				// Add the names of the mountains higher than the given level into the mountains list
				mountainsList.add(climbedMountains.get(i).get_name());
			}
		}
		
		return mountainsList;
	}
}
