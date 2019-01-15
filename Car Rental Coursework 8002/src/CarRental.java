import java.util.*;


/**
 * Author: Dharanidhar Puranam
 * Version: 1.0
 * Car rental class: Manages the rental agency
 */
public class CarRental implements ICarRental
{
    private ArrayList<Car> carsList = new ArrayList<Car>();
    private HashMap<DrivingLicence, Car> currentRentedCars = new HashMap<DrivingLicence, Car>();

    /**
     * Role: Constructor for car rental that creates cars
     */
    public CarRental()
    {
        createCars();
    }

    /**
     * Role: Creates large and small cars and adds them to a master list of all cars
     */
    private void createCars()
    {
        // Add small cars to the list
        for(int i = 0; i < 30; i++)
        {
            carsList.add(new SmallCar());
        }

        // Add large cars to the list
        for(int i = 0; i < 20; i++)
        {
            carsList.add(new LargeCar());
        }
    }

    /**
     * Role: Accessor for the list of cars. Returns all the cars in the rental agency
     * @return
     */
    @Override
    public ArrayList<Car> getCarsList()
    {
        return carsList;
    }

    /**
     * Role: Accessor for all cars that are currently rented
     * @return
     */
    @Override
    public HashMap<DrivingLicence, Car> getCurrentRentedCars()
    {
        return currentRentedCars;
    }

    /**
     * Role: Returns the number of specified (small/large) available cars
     * @param typeOfCar
     * @return
     */
    @Override
    public ArrayList<Car> availableCars(String typeOfCar)
    {
        ArrayList<Car> carsAvailable = new ArrayList<Car>();

        for(int i = 0; i < carsList.size(); i++)
        {
            if(typeOfCar == "small" && carsList.get(i).isSmall() && !carsList.get(i).isCarRented())
            {
                carsAvailable.add(carsList.get(i));
            }

            else if(typeOfCar == "large" && !carsList.get(i).isSmall() && !carsList.get(i).isCarRented())
            {
                carsAvailable.add(carsList.get(i));
            }
        }

        return carsAvailable;
    }

    /**
     * Role: Returns a car that is rented by the specified driving licence
     * @param drivingLicence
     * @return
     */
    @Override
    public Car getCar(DrivingLicence drivingLicence)
    {
        if(currentRentedCars.containsKey(drivingLicence))
        {
            return currentRentedCars.get(drivingLicence);
        }
        else
            {
                return null;
            }
    }

    /**
     * Role: Issues a car to a driver
     * @param drivingLicence
     * @param typeOfCar
     */
    @Override
    public boolean issueCar(DrivingLicence drivingLicence, String typeOfCar)
    {
        // Get age of the driver
        int age = dateDifference(drivingLicence.getDob());

        // Get number of years the licence is being held by the driver
        int licenceHeld = dateDifference(drivingLicence.getDateOfIssue());

        // If the driver is currently renting a car
        if(drivingLicence.getIsCurrentlyRenting())
        {
            return false;
        }

        // Loop through all the cars in the rental agency
        for (int i = 0; i < carsList.size(); i++)
        {
        	// If no cars are currently rented by the driver and the licence is full
            if(!drivingLicence.getIsCurrentlyRenting() && drivingLicence.isFullLicence())
            {
            	// If the type of car asked is small
                if(typeOfCar == "small" && carsList.get(i).isSmall() && !carsList.get(i).isCarRented() && carsList.get(i).isTankFull())
                {
                	// If age is less than 21 or licence held is less than 1
                    if(age < 21 || licenceHeld < 1)
                    {
                        return false;
                    }
                    else
                        {
                    		// Add the car and the drivers licence to the currently rented cars list
                            currentRentedCars.put(drivingLicence, carsList.get(i));
                            // Set the current car to rented
                            carsList.get(i).setIsCarRented(true);
                            // Set the drivers licence to rented
                            drivingLicence.setCurrentlyRenting(true);
                            return true;
                        }
                }
                
                // If the type of car asked is large
                else if(typeOfCar == "large" && !carsList.get(i).isSmall() && !carsList.get(i).isCarRented() && carsList.get(i).isTankFull())
                {
                	// If age is less than 25 or licence held is less than 5
                    if(age < 25 || licenceHeld < 5)
                    {
                        return false;
                    }
                    else
                    {
                    	// Add the car and the drivers licence to the currently rented cars list
                        currentRentedCars.put(drivingLicence, carsList.get(i));
                        // Set the current car to rented
                        carsList.get(i).setIsCarRented(true);
                        // Set the drivers licence to rented
                        drivingLicence.setCurrentlyRenting(true);
                        return true;
                    }
                }
            }
        }
		return false;
    }

    /**
     * Role: Calculates the difference in current date and specified date
     * @param date
     * @return
     */
    @Override
    public int dateDifference(Date date)
    {
        // Get an instance of current calendar
        Calendar today = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();

        // Set the calender to a specified date
        calendar.setTime(date);

        // Calculate year difference between today and specified date
        int yearDifference = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);

        // If current month less than specified date month
        if (today.get(Calendar.MONTH) < calendar.get(Calendar.MONTH))
        {
            // reduce 1 year
            yearDifference--;
        }

        // If current month same as specified date month and the current date is less than specified date
        else if (today.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < calendar.get(Calendar.DAY_OF_MONTH))
        {
            yearDifference--;
        }

        return yearDifference;
    }

    /**
     * Role: Terminates the rental agreement between car and the driver
     * @param drivingLicence
     * @return
     */
    @Override
    public int terminateRental(DrivingLicence drivingLicence)
    {
    	// If the driving licence is present
        if(currentRentedCars.containsKey(drivingLicence))
        {
        	// Store the car associated with the driving licence
            Car car = currentRentedCars.get(drivingLicence);
            
            // Check whether the tank is full or not full
            if(car.getFuelCapacity() - car.getCurrentFuel() > 0)
            {
            	// If not full ask to fill remaining the tank
                return car.getFuelCapacity() - car.getCurrentFuel();
            }
            else
                {
            		// If tank is full
            		// Set the driver licence currently renting to false
                    drivingLicence.setCurrentlyRenting(false);
                    // Set the car's rented status to false
                    currentRentedCars.get(drivingLicence).setIsCarRented(false);
                    // Remove the car from currently rented cars list
                    currentRentedCars.remove(drivingLicence);
                    // Terminate the licence
                    return car.getFuelCapacity() - car.getCurrentFuel();
                }
        }

        return -1;
    }
}