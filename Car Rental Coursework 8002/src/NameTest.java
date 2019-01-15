
import org.junit.jupiter.api.Test;

public class NameTest 
{
	
	private NameTest() {}
	
	public static void main(String[] args) 
	{
		final NameTest nt = new NameTest();
		
		nt.testName();
		
		nt.testGetFirstName();
		
		nt.testGetLastName();
		
		nt.testToString();
	}

	@Test()
	// Constructor test
	void testName() 
	{
		final String fName = "Mark";
		final String lName = "Smith";
		
		// Normal case
		final Name name = new Name(fName, lName);
		
		Assertions.assertEquals(fName, name.getFirstName());
		Assertions.assertEquals(lName, name.getLastName());
		
		// Null name case
		try 
		{
			final Name nullName = new Name(null, lName);
			Assertions.assertNotReached();
		} catch(Throwable t) 
		{
			Assertions.assertExpectedThrowable(NullPointerException.class, t);
		}
		
		// Empty name case
		try {
            final Name emptyName = new Name("", "");
            Assertions.assertNotReached();
        } catch (Throwable t) {
            Assertions.assertExpectedThrowable(
                IllegalArgumentException.class, t);
        }
		
		System.out.println("testName success");
	}
	
	@Test()
	// getFirstName test
	void testGetFirstName() 
	{
		final Name name = new Name("Mark", "Smith");
		Assertions.assertEquals("Mark", name.getFirstName());
		System.out.println("testGetFirstName success");
	}
	
	@Test()
	// testGetLastName test
	void testGetLastName() 
	{
		final Name name = new Name("Mark", "Smith");
		Assertions.assertEquals("Smith", name.getLastName());
		System.out.println("testGetLastName success");
	}
	
	@Test()
	// testToString test
	void testToString() 
	{
		final Name name = new Name("Mark", "Smith");
		Assertions.assertEquals("Mark Smith", name.toString());
		System.out.println("testToString success");
	}
}
