import org.junit.jupiter.api.Test;

public class LargeCarTest 
{	
	private LargeCarTest() {}
	
	public static void main(String[] args) 
	{
		final LargeCarTest lct = new LargeCarTest();
		
		lct.testLargeCar();
		
		lct.testIsSmall();
		
		lct.testDriveCar();
	}
	
	@Test
	// Constructor test
	void testLargeCar() 
	{
		final RegistrationNumber rn = new RegistrationNumber();
		final boolean isTankFull = true;
		final boolean isRented = false;
		final int fuelCapacity = 60;
		final boolean isSmall = false;
		
		final LargeCar lc = new LargeCar();
		final String regNum = lc.getRegistrationNumber();
		
		Assertions.assertEquals(regNum, lc.getRegistrationNumber());
		Assertions.assertEquals(isTankFull, lc.isTankFull());
		Assertions.assertEquals(isRented, lc.isCarRented());
		Assertions.assertEquals(fuelCapacity, lc.getFuelCapacity());
		Assertions.assertEquals(isSmall, lc.isSmall());
		
		System.out.println("testLargeCar success");
	}
	
	@Test
	void testIsSmall() 
	{
		final LargeCar lc = new LargeCar();
		
		Assertions.assertFalse(lc.isSmall());
		
		System.out.println("testIsSmall success");
	}

	@Test
	void testDriveCar() 
	{
		final LargeCar lc = new LargeCar();
		
		// When the distance entered is 0
		lc.setIsCarRented(true);
		lc.setCurrentFuel(60);
		int driveAmount = 0;
		Assertions.assertEquals(0, lc.driveCar(driveAmount));
		
		// When car is rented and fuel is greater than 0 - Car can be driven
		lc.setIsCarRented(true);
		lc.setCurrentFuel(60);
		driveAmount = 50;
		Assertions.assertEquals(5, lc.driveCar(driveAmount));
		
		// When car is not rented and fuel is greater than 0 - Car cannot be driven
		lc.setIsCarRented(false);
		lc.setCurrentFuel(60);
		driveAmount = 50;
		Assertions.assertEquals(0, lc.driveCar(driveAmount));
		
		// When car is rented but fuel is 0 - Car cannot be driven
		lc.setIsCarRented(true);
		lc.setCurrentFuel(0);
		driveAmount = 50;
		Assertions.assertEquals(0, lc.driveCar(driveAmount));
		
		System.out.println("testDriveCar success");
		
	}
}
