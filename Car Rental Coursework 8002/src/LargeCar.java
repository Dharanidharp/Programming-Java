/**
 * Author: Dharanidhar Puranam
 * Version: 1.0
 * Large Car class: Inherits abstract car
 */
public class LargeCar extends Car
{
    // Instance variables
    private int fuelCapacity = 60;
    private boolean isSmall = false;

    /**
     * Role: Constructs a large car
     */
    public LargeCar()
    {
        super();
        super.setFuelCapacity(fuelCapacity);
        super.setCurrentFuel(fuelCapacity);
    }

    @Override
    public boolean isSmall()
    {
        return isSmall;
    }

    /**
     * Role: Return the fuel consumed by the car while driving
     * @param distance
     * @return
     */
    public int driveCar(int distance)
    {
        int fuelConsumed = 0;

        if (distance <= 0) {
            System.out.println("No journey detected");
        }

        if (super.isCarRented() && (super.getCurrentFuel() > 0))
        {
            if(distance <= 50)
            {
                fuelConsumed = distance/10;
                super.setCurrentFuel(super.getCurrentFuel() - fuelConsumed);

                if(super.getCurrentFuel() <= 0)
                {
                    System.out.println("Car cannot be driven. Current fuel: " + super.getCurrentFuel());
                }
            }
            else
            {
                // Calculate the difference
                int difference = distance - 50;
                // Add extra fuel consumed
                fuelConsumed = (50/10) + (difference/15);
                super.setCurrentFuel(super.getCurrentFuel() - fuelConsumed);

                if(super.getCurrentFuel() <= 0)
                {
                    System.out.println("Car cannot be driven. Current fuel: " + super.getCurrentFuel());
                }
            }
        }
        return fuelConsumed;
    }
}