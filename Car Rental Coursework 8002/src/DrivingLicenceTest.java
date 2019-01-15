import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class DrivingLicenceTest 
{
	private DrivingLicenceTest() {}
	
	public static void main(String[] args) throws ParseException 
	{
		final DrivingLicenceTest dl = new DrivingLicenceTest();
		
		dl.testDrivingLicence();
		
		dl.testGetDateOfIssue();
		
		dl.testGetDob();
		
		dl.testGetDriverName();
		
		dl.testGetInitials();
		
		dl.testGetIsCurrentlyRenting();
		
		dl.testGetNumber();
		
		dl.testIsFullLicence();
		
		dl.testSetCurrentlyRenting();
		
		dl.testYearIssued();
		
		dl.testToString();
	}
	
	@Test
	// Constructor test
	void testDrivingLicence() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		final Date dob = df.parse("11-10-1995");
		final Date doi = df.parse("01-03-2015");
		final boolean isFull = true;
		
		final DrivingLicence dl = new DrivingLicence(name, dob, doi, isFull);
		
		final LicenceNumber number = dl.getNumber();
		
		Assertions.assertEquals(name, dl.getDriverName());
		Assertions.assertEquals(dob, dl.getDob());
		Assertions.assertEquals(doi, dl.getDateOfIssue());
		Assertions.assertEquals(isFull, dl.isFullLicence());
		Assertions.assertEquals(number, dl.getNumber());
		
		// Null cases
		try 
		{
			final DrivingLicence nullDl = new DrivingLicence(null, null, doi, isFull);
			Assertions.assertNotReached();
		} catch(Throwable t) 
		{
			Assertions.assertExpectedThrowable(NullPointerException.class, t);
		}		
		
		System.out.println("testDrivingLicence success");
	}
	
	@Test
	void testGetInitials() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		Assertions.assertEquals("MS", dl.getInitials(name.toString()));
		
		System.out.println("testGetInitials success");
	}

	@Test
	void testYearIssued() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		Assertions.assertEquals(2015, dl.yearIssued());
		
		System.out.println("testYearIssued success");
	}

	@Test
	void testGetDriverName() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		Assertions.assertEquals(name, dl.getDriverName());
		
		System.out.println("testGetDriverName success");
	}

	@Test
	void testGetDob() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		Assertions.assertEquals(df.parse("11-10-1995"), dl.getDob());
		
		System.out.println("testGetDob success");
	}

	@Test
	void testGetDateOfIssue() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
				
		Assertions.assertEquals(df.parse("01-03-2015"), dl.getDateOfIssue());
		
		System.out.println("testGetDateOfIssue success");
	}

	@Test
	void testGetNumber() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		final LicenceNumber ln = dl.getNumber();
		
		Assertions.assertEquals(ln, dl.getNumber());
		
		System.out.println("testGetNumber success");
	}

	@Test
	void testIsFullLicence() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		Assertions.assertTrue(dl.isFullLicence());
		
		System.out.println("testIsFullLicence success");
	}

	@Test
	void testGetIsCurrentlyRenting() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		Assertions.assertFalse(dl.getIsCurrentlyRenting());
		
		System.out.println("testGetIsCurrentlyRenting success");
	}

	@Test
	void testSetCurrentlyRenting() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		dl.setCurrentlyRenting(false);
		
		Assertions.assertFalse(dl.getIsCurrentlyRenting());
		
		System.out.println("testSetCurrentlyRenting success");
	}

	@Test
	void testToString() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		final String s = dl.toString();
		
		Assertions.assertEquals(s, dl.toString());
		
		System.out.println("testToString success");
	}

}
