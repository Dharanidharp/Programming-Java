/**
 * Mountain: Creates and registers new mountains that climbers climbed
 * @author Dharanidhar
 *@version 1.0
 */

public class Mountain 
{
	// Declaring instance variables
	private String mountainName;
	private int mountainHeight;
	
	/**
	 * Key roles:
	 * Constructor for mountain class
	 * Creates a mountain with a name and a height
	 * @param mName Takes the name of the mountain entered by the user and stores it 
	 * @param mHeight Takes the height of the mountain entered by the user and stores it
	 */
	public Mountain(String mName, int mHeight) 
	{
		// Initialise instance variable
		mountainName = mName;
		mountainHeight = mHeight;
	}
	
	// Set mountain height
	public void set_Height(int mHeight)
	{
		mountainHeight = mHeight;
	}
	
	// Accessor method for mountain height
	public int get_Height() 
	{
		return mountainHeight;
	}
	
	// Set mountain name
	public void set_Name(String mName) 
	{
		mountainName = mName;
	}
	
	// Accessor method for mountain name
	public String get_name() 
	{
		return mountainName;
	}
}
