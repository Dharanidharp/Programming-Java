import org.junit.jupiter.api.Test;

public class SmallCarTest 
{
	
	private SmallCarTest() {}
	
	public static void main(String[] args) 
	{
		final SmallCarTest sct = new SmallCarTest();
		
		sct.testSmallCar();
		
		sct.testIsSmall();
		
		sct.testDriveCar();
	}
	
	@Test
	// Constructor test
	void testSmallCar() 
	{
		final RegistrationNumber rn = new RegistrationNumber();
		final boolean isTankFull = true;
		final boolean isRented = false;
		final int fuelCapacity = 49;
		final boolean isSmall = true;
		
		final SmallCar sc = new SmallCar();
		final String regNum = sc.getRegistrationNumber();
		
		Assertions.assertEquals(regNum, sc.getRegistrationNumber());
		Assertions.assertEquals(isTankFull, sc.isTankFull());
		Assertions.assertEquals(isRented, sc.isCarRented());
		Assertions.assertEquals(fuelCapacity, sc.getFuelCapacity());
		Assertions.assertEquals(isSmall, sc.isSmall());
		
		System.out.println("testSmallCar success");
	}
	
	@Test
	void testIsSmall() 
	{
		final SmallCar sc = new SmallCar();
		
		Assertions.assertTrue(sc.isSmall());
		
		System.out.println("testIsSmall success");
	}

	@Test
	void testDriveCar() 
	{
		final SmallCar sc = new SmallCar();
		
		// When the distance entered is 0
		sc.setIsCarRented(true);
		sc.setCurrentFuel(49);
		int driveAmount = 0;
		Assertions.assertEquals(0, sc.driveCar(driveAmount));
		
		// When car is rented and fuel is greater than 0 - Car can be driven
		sc.setIsCarRented(true);
		sc.setCurrentFuel(49);
		driveAmount = 50;
		Assertions.assertEquals(2, sc.driveCar(driveAmount));
		
		// When car is not rented and fuel is greater than 0 - Car cannot be driven
		sc.setIsCarRented(false);
		sc.setCurrentFuel(49);
		driveAmount = 50;
		Assertions.assertEquals(0, sc.driveCar(driveAmount));
		
		// When car is rented but fuel is 0 - Car cannot be driven
		sc.setIsCarRented(true);
		sc.setCurrentFuel(0);
		driveAmount = 50;
		Assertions.assertEquals(0, sc.driveCar(driveAmount));
		
		System.out.println("testDriveCar success");
	}

}
