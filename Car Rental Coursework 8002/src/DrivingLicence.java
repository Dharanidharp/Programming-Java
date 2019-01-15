import java.util.Calendar;
import java.util.Date;

/**
 * Author: Dharanidhar Puranam
 * Version: 1.0
 * Driving Licence class: Creates a driving licence with a unique licence number
 */
public final class DrivingLicence
{
    // Declaring instance variables
    private final Name driverName;
    private final Date dob;
    private final Date dateOfIssue;
    private final LicenceNumber number;
    private final boolean isFullLicence;
    private boolean currentlyRenting = false;

    /**
     * Role: Constructs a new driving licence with a unique licence number
     * @param driverName
     * @param dob
     * @param dateOfIssue
     * @param isFullLicence
     */
    public DrivingLicence(Name driverName, Date dob, Date dateOfIssue, boolean isFullLicence)
    { 	
    	
        this.driverName = driverName;
        this.dob = dob;
        this.dateOfIssue = dateOfIssue;
        this.isFullLicence = isFullLicence;

        // Create a licence number by calling the getInitials method and yearIssued method
        this.number = new LicenceNumber(getInitials(driverName.toString()), yearIssued());
    }

    /**
     * Role: Get the first and last names of the driver along with the first letters of both first and lastname. It takes a string as parameter
     * @param name
     * @return
     */
    public String getInitials(String name)
    {
        // Split the first and last names and store in a string array
        String[] fullName = name.split(" ");

        // Store the first letter of the first name
        char f = fullName[0].charAt(0);

        // Store the first letter of the last name
        char l = fullName[1].charAt(0);

        // return the first letters of first and last names as a string
        return f + "" + l;
    }

    /**
     * Role: Get the year of issue of the driving licence
     * @return
     */
    public int yearIssued()
    {
        Date date = getDateOfIssue();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * Role: Accessor method for driver name
     * @return
     */
    public Name getDriverName() {
        return driverName;
    }

    /**
     * Role: Accessor method for driver date of birth
     * @return
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Role: Accessor method for licence date of issue
     * @return
     */
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    /**
     * Role: Accessor method for driver licence number
     * @return
     */
    public LicenceNumber getNumber() {
        return number;
    }

    /**
     * Role: Accessor method for full licence
     * @return
     */
    public boolean isFullLicence() {
        return isFullLicence;
    }

    /**
     * Role: Accessor method for currently renting car
     * @return
     */
    public boolean getIsCurrentlyRenting()
    {
        return currentlyRenting;
    }

    /**
     * Role: Sets currently renting car to true or false
     * @param currentlyRenting
     */
    public void setCurrentlyRenting(boolean currentlyRenting)
    {
        this.currentlyRenting = currentlyRenting;
    }

    @Override
    public String toString() {
        return "Driving Licence"
                + "\nDriver name: " + getDriverName()
                + "\nDriver DOB: " + getDob()
                + "\nLicence date of issue: " + getDateOfIssue()
                + "\nLicence number: " + getNumber()
                + "\nIs full licence: " + isFullLicence();
    }
}