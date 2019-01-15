import java.util.Random;

/**
 * Author: Dharanidhar Puranam
 * Version: 1.0
 * Licence number: Generates unique licence number
 */
public final class LicenceNumber
{
    // Instance variables
    private final String fL; // f - first name, l - last name
    private final int yearIssued;
    private final int serialNumber;

    /**
     * Role: Construct a new licence number with initials, year of issue and a random serial number between 1-99
     * @param fL
     * @param yearIssued
     */
    public LicenceNumber(String fL, int yearIssued)
    {    	
        this.fL = fL;
        this.yearIssued = yearIssued;
        this.serialNumber = generateSerialNumber();
    }

    /**
     * Role: Generate a random number between 1 and 99
     * @return
     */
    private int generateSerialNumber()
    {
        int num = 98;
        Random random = new Random();
        int randomNumber = random.nextInt(num) + 1;
        return randomNumber;
    }

    /**
     * Role: Concatenate the initials, year of issue and serial number into a single string - MS-1990-25
     * @return
     */
    @Override
    public String toString()
    {
        return getfL() + "-" + getYearIssued() + "-" + getSerialNumber();
    }

    /**
     * Role: Accessor method for the initials
     * @return
     */
    public String getfL() {
        return fL;
    }

    /**
     * Role: Accessor method for year of issue
     * @return
     */
    public int getYearIssued() {
        return yearIssued;
    }

    /**
     * Role: Accessor method for serial number
     * @return
     */
    public int getSerialNumber() {
        return serialNumber;
    }
}