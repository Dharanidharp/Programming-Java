/**
 * Author: Dharanidhar Puranam
 * Version: 1.0
 * Car class (abstract): Creates an abstract car
 */
public abstract class Car implements ICar
{
    private RegistrationNumber number;
    private int fuelCapacity;
    private int currentFuel;
    private boolean isFull;
    private boolean isRented;

    /**
     * Role: Constructs a car
     */
    public Car()
    {
        number = new RegistrationNumber();
        isFull = true;
        isRented = false;
    }

    /**
     * Role: Accessor method
     * @return
     */
    public String getRegistrationNumber()
    {
        return number.toString();
    }

    /**
     * Role: Sets fuel capacity
     * @param fuelCapacity
     */
    public void setFuelCapacity(int fuelCapacity)
    {
        this.fuelCapacity = fuelCapacity;
    }

    /**
     * Role: Accessor method
     * @return
     */
    public int getFuelCapacity()
    {
        return fuelCapacity;
    }

    /**
     * Role: Sets a specified amount of fuel to current fuel
     * @param currentFuel
     */
    public void setCurrentFuel(int currentFuel)
    {
        this.currentFuel = currentFuel;
    }

    /**
     * Role: Accessor method
     * @return
     */
    public int getCurrentFuel()
    {
        return currentFuel;
    }

    /**
     * Role: Calculates fuel in the tank and returns true or false
     * @return
     */
    public boolean isTankFull()
    {
        if(currentFuel - fuelCapacity >= 0)
        {
            return true;
        }else
            {
                return false;
            }
    }

    /**
     * Role: Accessor method that returns whether the car is rented or not
     * @return
     */
    public boolean isCarRented()
    {
        return isRented;
    }

    /**
     * Role: Set whether the car is rented or not
     * @param b
     */
    public void setIsCarRented(boolean b)
    {
        isRented = b;
    }

    /**
     * Role: Method to add fuel to car
     * @param fuelAmount
     * @return
     */
    public int addFuel(int fuelAmount)
    {
        if(fuelAmount <= 0)
        {
            System.out.println("Fuel amount must be greater than zero");
        }

        // If tank is full or car is not rented
        if(isTankFull() || !isRented)
        {
            return 0;
        }

        // Add fuel until tank is filled
        if((currentFuel + fuelAmount) <= fuelCapacity)
        {
            currentFuel += fuelAmount;
            isFull = true;
            return fuelAmount;
        }

        // If the added fuel amount is greater than fuel capacity
        if((currentFuel + fuelAmount) > fuelCapacity)
        {
            // Calculate the extra amount
            int difference = fuelCapacity - currentFuel;
            // Set current fuel to fuel capacity
            currentFuel = fuelCapacity;
            isFull = true;
            return difference;
        }
        return -1;
    }
}