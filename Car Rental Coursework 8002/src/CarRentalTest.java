import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

public class CarRentalTest 
{
	private CarRentalTest() {}
	
	public static void main(String[] args) throws ParseException 
	{
		final CarRentalTest crt = new CarRentalTest();
		
		crt.testCarRental();
		
		crt.testAvailableCars();
		
		crt.testDateDifference();
		
		crt.testGetCar();
		
		crt.testGetCarsList();
		
		crt.testGetCurrentRentedCars();
		
		crt.testIssueCar();
		
		crt.testTerminateRental();
		
		CarRental cr = new CarRental();
		System.out.println(cr.getCarsList().size());
	}
	
	@Test
	// Constructor test
	void testCarRental() 
	{
		// Creates 50 cars when instantiated
		final CarRental cr = new CarRental();
		
		// Total number of cars in the fleet - 50 (30 small, 20 large)
		Assertions.assertEquals(50, cr.getCarsList().size());
		
		System.out.println("testCarRental success");
	}

	@Test
	void testGetCarsList() 
	{
		final CarRental cr = new CarRental();
	
		// Total number of cars in the fleet - 50 (30 small, 20 large)
		Assertions.assertEquals(50, cr.getCarsList().size());
		
		System.out.println("testGetCarsList success");
	}

	@Test
	void testGetCurrentRentedCars() throws ParseException 
	{	
		final CarRental cr = new CarRental();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		// Assert that no car is rented currently
		Assertions.assertEquals(0, cr.getCurrentRentedCars().size());
		
		// Issue a small car
		cr.issueCar(dl, "small");
		cr.getCurrentRentedCars();
		
		// Assert that only 1 car is rented currently
		Assertions.assertEquals(1, cr.getCurrentRentedCars().size());
		
		// Terminate the rental contract
		cr.terminateRental(dl);
		
		// Assert that no car is rented currently
		Assertions.assertEquals(0, cr.getCurrentRentedCars().size());
		
		System.out.println("testGetCurrentRentedCars success");
	}

	@Test
	void testAvailableCars() throws ParseException 
	{	
		final CarRental cr = new CarRental();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1990"),df.parse("01-03-2013"),true);
		
		// Assert that there are 30 small cars available to rent
		Assertions.assertEquals(30, cr.availableCars("small").size());
		
		// Assert that there are 20 large cars available to rent
		Assertions.assertEquals(20, cr.availableCars("large").size());
		
		// Issue a small car
		cr.issueCar(dl, "small");
		
		// Assert that there are 29 small cars available to rent
		Assertions.assertEquals(29, cr.availableCars("small").size());
		
		//Terminate the previous small car contract
		cr.terminateRental(dl);
		
		// Issue a large car
		cr.issueCar(dl, "large");
				
		// Assert that there are 19 large cars available to rent
		Assertions.assertEquals(19, cr.availableCars("large").size());
		
		System.out.println("testAvailableCars success");
	}

	@Test
	void testGetCar() throws ParseException 
	{	
		final CarRental cr = new CarRental();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1990"),df.parse("01-03-2013"),true);
		
		// Issue a small car
		cr.issueCar(dl, "small");
		
		// Store the registration number of the rented small car
		final String regNum = cr.getCurrentRentedCars().get(dl).getRegistrationNumber();
		
		// Assert that the registration number of the stored rented car and the registration number of the specified car are same
		Assertions.assertEquals(regNum, cr.getCar(dl).getRegistrationNumber());
		
		System.out.println("testGetCar success");
	}

	@Test
	void testIssueCar() throws ParseException 
	{	
		final CarRental cr = new CarRental();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		// Assert true and Issue small car when the driver is not renting any other car
		Assertions.assertTrue(cr.issueCar(dl, "small"));
		
		// Assert that the driving is currently renting a car
		Assertions.assertTrue(dl.getIsCurrentlyRenting());
		
		// Store the registration number of the rented car
		String regNum = cr.getCurrentRentedCars().get(dl).getRegistrationNumber();
		
		// Check whether the rented cars are same by checking the registration numbers
		Assertions.assertEquals(regNum, cr.getCar(dl).getRegistrationNumber());
		
		// Assert false and Issue large car when driver is currently renting an another car (previous small car) -  Driver can only rent one car at a time
		Assertions.assertFalse(cr.issueCar(dl, "large"));
		
		// Terminate the current rental associated with the above driver
		cr.terminateRental(dl);
		
		// Assert false (the driver is not old enough (23 years) to rent a large car - 25 years required)
		Assertions.assertFalse(cr.issueCar(dl, "large"));
		
		// Create a new older driver with old driving licence issue
		DrivingLicence dlB = new DrivingLicence(name, df.parse("11-10-1990"),df.parse("01-03-2013"),true);
		
		// Assert true (the driver is eligible now to rent a large car) and Issue large car
		Assertions.assertTrue(cr.issueCar(dlB, "large"));
		
		// Assert that the driving is currently renting a car
		Assertions.assertTrue(dlB.getIsCurrentlyRenting());
		
		// Store the registration number of the rented car
		regNum = cr.getCurrentRentedCars().get(dlB).getRegistrationNumber();
				
		// Check whether the rented cars are same by checking the registration numbers
		Assertions.assertEquals(regNum, cr.getCar(dlB).getRegistrationNumber());
		
		System.out.println("testIssueCar success");
	}

	@Test
	void testDateDifference() throws ParseException 
	{	
		final CarRental cr = new CarRental();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2013"),true);
		
		// Check age difference when different months (11th October 1995 (22 years old) and today's date)
		Assertions.assertEquals(22, cr.dateDifference(dl.getDob()));
		
		DrivingLicence dlB = new DrivingLicence(name, df.parse("05-03-1995"),df.parse("01-03-2013"),true);
		
		// Check age difference when different months (5th March 1995 (23 years old) and today's date)
		Assertions.assertEquals(23, cr.dateDifference(dlB.getDob()));
		
		System.out.println("testDateDifference success");
	}

	@Test
	void testTerminateRental() throws ParseException 
	{	
		final CarRental cr = new CarRental();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1990"),df.parse("01-03-2013"),true);
		
		// Assert true and Issue small car when the driver is not renting any other car
		Assertions.assertTrue(cr.issueCar(dl, "small"));
				
		// Assert that the driving is currently renting a car
		Assertions.assertTrue(dl.getIsCurrentlyRenting());
				
		// Check whether the rented cars are same by checking the registration numbers
		Assertions.assertEquals(cr.getCurrentRentedCars().get(dl).getRegistrationNumber(), cr.getCar(dl).getRegistrationNumber());
		
		// Drive the car
		cr.getCurrentRentedCars().get(dl).driveCar(50);
		
		// Terminate rental when tank is not full - fuel used 2 litres, amount to fill 2 litres
		Assertions.assertEquals(2, cr.terminateRental(dl));
		
		// Add 2 litres to the tank
		cr.getCurrentRentedCars().get(dl).addFuel(2);
		
		// Terminate rental when the remaining fuel is added
		Assertions.assertEquals(0, cr.terminateRental(dl));
		
		System.out.println("testTerminateRental success");
	}
}
