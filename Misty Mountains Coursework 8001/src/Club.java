
// Importing the required java libraries
import java.util.ArrayList;

/**
 * Club: This class is meant to add new climber and their climbed mountains to the club
 * @author Dharanidhar
 *@version 1.0
 */
public class Club 
{
	// An Array list of all the climbers names
	public ArrayList<String> climberNames = new ArrayList<>();
	
	// An Array list of all the climbers registered
	public ArrayList<Climber> climbersList = new ArrayList<>();
	
	// An Array list of all the mountains climbed in the club
	public ArrayList<Mountain> allMountainsClimbed = new ArrayList<>();
	
	// An Array list of all the mountains that are greater than a given level
	public ArrayList<String> mountainsList = new ArrayList<>();
	
	// An Array list of all the average heights climbed by all the climbers in the club
	private ArrayList<Double> averageHeightsList = new ArrayList<>();
	
	// Initialising an instance variable
	public double highestAverageHeightRecorded = 0;
	
	/**
	 * Key roles: 
	 * Adds new climbers to a list of climbers
	 * Adds climbers names to a list
	 * Adds the average height climbed by the climber to a list
	 * @param newClimber: The climber object created from the constructor in the Climber class that contains climber name, age and gender
	 */
		public void addClimber(Climber newClimber) 
		{
			// Add the climber object
			climbersList.add(newClimber);
			
			// Add the climbers name by calling the accessor method from the Climber class
			climberNames.add(newClimber.getClimberName());
			
			// Add the average height climbed by the climber
			averageHeightsList.add(newClimber.averageHeight());
		}
		
		/**
		 * Key roles:
		 * Returns the climbers list
		 * @return climbersList arrayList
		 */
		// Accessor method for climbers list
		public ArrayList<Climber> getClimber() 
		{
			return climbersList;
		}
		
		/**
		 * Key roles:
		 * Add all the average heights recorded to a list and return the highest average
		 * Looks at the individual average heights of the climbers
		 * Stores the average height of the first climber as the highest height recorded and then compares it with the average height of the current climber in the list
		 * @return Returns the Climber that has recorded the highest average height
		 */
		public Climber highestAverageHeight() 
		{
			// Initialising an index variable for accessing the array elements of the climbers list
			int index = 0;
			
			// Store the first climber from the climbers list as the person who recorded the highest average
			Climber highestAvgRecorded = climbersList.get(index);
			
			// Store the first climbers average height as the highest average recorded in the club
			highestAverageHeightRecorded = climbersList.get(index).averageHeight();
			
			// Check the entire average heights list for the highest average recorded
			while(index < averageHeightsList.size()) 
			{
				// Instance of the climber class to store the current climber
				Climber thisClimber = climbersList.get(index);
				
				// Compare the average height climbed by this climber with the highestAverageHeight that is stored in the club
				if(thisClimber.averageHeight() > highestAvgRecorded.averageHeight()) 
				{
					// In case the average height of current climber is greater, then make this climbers average height as the highest average height recorded
					highestAvgRecorded = thisClimber;
					highestAverageHeightRecorded = thisClimber.averageHeight();
				}
				
				else 
				{
					// Increase the value of the index by 1
					index++;
				}
			}
			
			return highestAvgRecorded;
		}
		
		/**
		 * Key roles:
		 * Looks at the individual highest mountains climbed by the climbers
		 * Stores the height of the highest mountain climbed by the first climber in the list as the highest height and then compares it with the height of the current climber's highest mountain in the list
		 * @return Returns the highest mountain recorded in the club
		 */
		// Find the highest mountain recorded by all the climbers
		public Mountain getHighestMountainRecorded() 
		{
			// Initialising an index variable for accessing the array elements of the climbers list
			int index = 0;
			
			// Store the first mountain climbed by the first climber as the highest mountain
			Mountain highestMountain = climbersList.get(index).getHighestMountain();
			
			// Loop through the climbers list
			while(index < climbersList.size()) 
			{
				// Instance of the mountain class to store current mountain object
				Mountain thisMountain = climbersList.get(index).getHighestMountain();
				
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
		 * Display a list of mountains climbed with height greater than a given level
		 * Compares the heights of all the mountains in the list with the level
		 * @param level: Stores a height that is entered by the user
		 * @return Returns the mountain names that are higher than entered level
		 */
		public ArrayList<String> getMountainsHigherThanALevel(int level)
		{
			// Clear the mountains list array
			mountainsList.clear();
			
			// Loop through all mountains climbed list 
			for(int i = 0; i < allMountainsClimbed.size(); i++) 
			{
				// Compare the current height of the mountain in the climbed mountains list with the level entered
				if(allMountainsClimbed.get(i).get_Height() > level) 
				{
					// Add the names of the mountains higher than the given level into the mountains list
					mountainsList.add(allMountainsClimbed.get(i).get_name());
				}
			}
			
			return mountainsList;
		}
}
