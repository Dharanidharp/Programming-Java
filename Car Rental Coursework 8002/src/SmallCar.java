/**
 * Author: Dharanidhar Puranam
 * Version: 1.0
 * Small Car class: Inherits abstract car
 */
public class SmallCar extends Car
{
    // Instance variables
    private int fuelCapacity = 49;
    private boolean isSmall = true;

    /**
     * Role: Constructs a small car
     */
    public SmallCar()
    {
        super();
        super.setFuelCapacity(fuelCapacity);
        super.setCurrentFuel(fuelCapacity);
    }

    @Override
    public boolean isSmall() {
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

        if(distance <= 0)
        {
            System.out.println("No journey detected");
        }

        if(super.isCarRented() && super.getCurrentFuel() > 0)
        {
            fuelConsumed = distance / 20;
            super.setCurrentFuel(super.getCurrentFuel() - fuelConsumed);

            if(super.getCurrentFuel() <= 0)
            {
                System.out.println("Car cannot be driven. Current fuel: " + super.getCurrentFuel());
            }
        }
        return fuelConsumed;
    }
}