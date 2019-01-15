import org.junit.jupiter.api.Test;


public class RegistrationNumberTest 
{
	
	private RegistrationNumberTest() {}
	
	public static void main(String[] args) 
	{
		final RegistrationNumberTest rn = new RegistrationNumberTest();
		
		rn.testRegistrationNumber();
		
		rn.testGetLetterComponent();
		
		rn.testGetNumberComponent();
		
		rn.testToString();
	}
	
	@Test
	// Constructor test
	void testRegistrationNumber() 
	{
		// Random case check
		final RegistrationNumber rn = new RegistrationNumber();
		
		final char letterComponent = rn.getLetterComponent();
	    final int numberComponent = rn.getNumberComponent();
		
		Assertions.assertEquals(letterComponent, rn.getLetterComponent());
		Assertions.assertEquals(numberComponent, rn.getNumberComponent());
		
		System.out.println("testRegistrationNumber success");
	}

	@Test()
	void testGetLetterComponent() 
	{
		final RegistrationNumber rn = new RegistrationNumber();
		final char letterComponent = rn.getLetterComponent();
		Assertions.assertEquals(letterComponent, rn.getLetterComponent());
		System.out.println("testGetLetterComponent success");
	}

	@Test()
	void testGetNumberComponent() 
	{
		final RegistrationNumber rn = new RegistrationNumber();
		final int numberComponent = rn.getNumberComponent();
		Assertions.assertEquals(numberComponent, rn.getNumberComponent());
		System.out.println("testGetNumberComponent success");
	}
	
	@Test()
	void testToString() 
	{
		final RegistrationNumber rn = new RegistrationNumber();
		final char letterComponent = rn.getLetterComponent();
	    final int numberComponent = rn.getNumberComponent();
	    Assertions.assertEquals(letterComponent + "" + numberComponent, rn.toString());
	    System.out.println("testToString success");
	}
}
