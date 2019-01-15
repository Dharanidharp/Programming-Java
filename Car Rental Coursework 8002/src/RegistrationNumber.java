import java.util.Random;

/**
 * Author: Dharanidhar Puranam
 * Version: 1.0
 * Registration number class: Creates a unique registration number for a car
 */
public final class RegistrationNumber
{
    // Instance variables
    private final char letterComponent;
    private final int numberComponent;

    /**
     * Role: Constructs a new registration number
     */
    public RegistrationNumber()
    {
        this.letterComponent = generateChar();
        this.numberComponent = generateNumber();
    }

    /**
     * Role: Concatenate the letter and number components
     * @return
     */
    @Override
    public String toString()
    {
        // Concatenate the letter and number component
        return getLetterComponent() + "" + getNumberComponent();
    }

    /**
     * Role: Generate the letter component of the registration number
     * @return
     */
    private char generateChar()
    {
        Random random = new Random();
        char letter = (char)(random.nextInt(26) + 'A');
        return letter;
    }

    /**
     * Role: Generate the number component of the registration number
     * @return
     */
    private int generateNumber()
    {
        int numA = 9000, numB = 1000;
        Random random = new Random();
        int number = random.nextInt(numA) + numB;
        return number;
    }

    /**
     * Role: Accessor for letter component of the registration number
     * @return
     */
    public char getLetterComponent()
    {
        return letterComponent;
    }

    /**
     * Role: Accessor for number component of the registration number
     */
    public int getNumberComponent()
    {
        return numberComponent;
    }
    
    /**
     * Role: Checks whether the instances of the object are similar
     */
    public boolean equals(Object o) 
    {
        if (this == o) return true;
        
        if(!(o instanceof RegistrationNumber)) return false;
        
        RegistrationNumber rn = (RegistrationNumber) o;
        
        return letterComponent == rn.letterComponent && numberComponent == rn.numberComponent;
    }
}