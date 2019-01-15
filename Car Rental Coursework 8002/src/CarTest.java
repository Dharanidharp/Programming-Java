import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest 
{
	
	private CarTest() {}
	
	public static void main(String[] args) 
	{
		final CarTest carTest = new CarTest();
		
		carTest.testCar();
		
		carTest.testAddFuel();
		
		carTest.testGetCurrentFuel();
		
		carTest.testGetFuelCapacity();
		
		carTest.testGetRegistrationNumber();
		
		carTest.testIsCarRented();
		
		carTest.testIsTankFull();
		
		carTest.testSetCurrentFuel();
		
		carTest.testSetFuelCapacity();
		
		carTest.testSetIsCarRented();
	}
	
	@Test
	// Constructor test
	void testCar() 
	{
		final RegistrationNumber rn = new RegistrationNumber();
		final boolean isTankFull = true;
		final boolean isRented = false;
		
		final Car car = new SmallCar();
		final String regNum = car.getRegistrationNumber();
		
		Assertions.assertEquals(regNum, car.getRegistrationNumber());
		Assertions.assertEquals(isTankFull, car.isTankFull());
		Assertions.assertEquals(isRented, car.isCarRented());
		
		System.out.println("testCar success");
	}

	@Test
	void testGetRegistrationNumber() 
	{
		final RegistrationNumber rn = new RegistrationNumber();
		
		final Car car = new SmallCar();
		
		final String regNum = car.getRegistrationNumber();
		
		Assertions.assertEquals(regNum, car.getRegistrationNumber());
		
		System.out.println("testGetRegistrationNumber success");
	}

	@Test
	void testSetFuelCapacity() 
	{
		final Car car = new SmallCar();
		
		car.setFuelCapacity(49);
		
		final int fuel = 49;
		
		Assertions.assertEquals(fuel, car.getFuelCapacity());
		
		System.out.println("testSetFuelCapacity success");
	}

	@Test
	void testGetFuelCapacity() 
	{
		final Car car = new SmallCar();
		
		final int fuel = 49;
		
		Assertions.assertEquals(fuel, car.getFuelCapacity());
		
		System.out.println("testGetFuelCapacity success");
	}

	@Test
	void testSetCurrentFuel() 
	{
		final Car car = new SmallCar();
		
		car.setCurrentFuel(30);
		
		final int fuel = 30;
		
		Assertions.assertEquals(fuel, car.getCurrentFuel());
		
		System.out.println("testSetCurrentFuel success");
	}

	@Test
	void testGetCurrentFuel() 
	{
		final Car car = new SmallCar();
		
		final int fuel = 49;
		
		Assertions.assertEquals(fuel, car.getCurrentFuel());
		
		System.out.println("testGetCurrentFuel success");
	}

	@Test
	void testIsTankFull() 
	{
		final Car car = new SmallCar();
		
		Assertions.assertTrue(car.isTankFull());
		
		System.out.println("testIsTankFull success");
	}

	@Test
	void testIsCarRented() 
	{
		final Car car = new SmallCar();
		
		Assertions.assertFalse(car.isCarRented());
		
		System.out.println("testIsCarRented success");
	}

	@Test
	void testSetIsCarRented() 
	{
		final Car car = new SmallCar();
		
		car.setIsCarRented(true);
		
		Assertions.assertTrue(car.isCarRented());
		
		System.out.println("testSetIsCarRented success");
	}

	@Test
	void testAddFuel() 
	{
		final Car car = new SmallCar();
		
		// Case 1 - tank full and not rented
		Assertions.assertEquals(0, car.addFuel(30));
		
		// Case 2 - tank full and rented
		car.setIsCarRented(true);
		Assertions.assertEquals(0, car.addFuel(30));
		
		// Case 3 - not full
		car.setCurrentFuel(20);
		car.setIsCarRented(true);
		
		// The fuel capacity is only 49, hence what ever the amount value, the difference would be 29
		Assertions.assertEquals(29, car.addFuel(30));
		
		System.out.println("testAddFuel success");
	}

}
