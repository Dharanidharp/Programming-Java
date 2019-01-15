/**
 * Author: Dharanidhar Puranam
 * Version: 1.0
 * Name class: Creates the name of the person
 */
public final class Name
{
    // Declares first and last name variables
    private final String firstName;
    private final String lastName;

    /**
     * Role: Constructs a name object with first and last names
     * @param fName
     * @param lName
     */
    public Name(String fName, String lName)
    {
    	if(fName.length() == 0 || lName.length() == 0) 
    	{
    		throw new IllegalArgumentException("empty string");
    	}
    	
        this.firstName = fName;
        this.lastName = lName;
    }

    /**
     * Role: Accessor for first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Role: Accessor for last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Role: Concatenate first and last names into a string
     * @return
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}