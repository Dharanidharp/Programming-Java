import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class LicenceNumberTest 
{
	private LicenceNumberTest() {}
	
	public static void main(String[] args) throws ParseException 
	{
		final LicenceNumberTest ln = new LicenceNumberTest();
		
		ln.testLicenceNumber();
		
		ln.testGetfL();
		
		ln.testGetSerialNumber();
		
		ln.testGetYearIssued();
		
		ln.testToString();
	}
	
	@Test
	// Constructor test
	void testLicenceNumber() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		final Name name = new Name("Mark", "Smith");
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		final String initials = dl.getDriverName().toString();
		final int year = dl.yearIssued();
		
		final LicenceNumber number = new LicenceNumber(initials, year);
		final int serialNumber = number.getSerialNumber();
		
		Assertions.assertEquals(initials, number.getfL());
		Assertions.assertEquals(year, number.getYearIssued());
		Assertions.assertEquals(serialNumber, number.getSerialNumber());
		
		// Null cases
		try 
		{
			final LicenceNumber nullLn = new LicenceNumber(null, (Integer) null);
			Assertions.assertNotReached();
		} catch(Throwable t) 
		{
			Assertions.assertExpectedThrowable(NullPointerException.class, t);
		}	
		
		System.out.println("testLicenceNumber success");
	}	
	
	@Test
	void testToString() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		final LicenceNumber number = new LicenceNumber(dl.getInitials(name.toString()), dl.yearIssued());
		
		final String licenceNumberString = number.toString();
		
		Assertions.assertEquals(licenceNumberString, number.toString());
		
		System.out.println("testToString success");
	}

	@Test
	// Test name initials
	void testGetfL() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		final LicenceNumber number = new LicenceNumber(dl.getInitials(name.toString()), dl.yearIssued());
		
		final String initials = "MS";
		
		Assertions.assertEquals(initials, number.getfL());
		
		System.out.println("testGetfL success");
	}

	@Test
	void testGetYearIssued() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		final LicenceNumber number = new LicenceNumber(dl.getInitials(name.toString()), dl.yearIssued());
		
		final int year = 2015;
		
		Assertions.assertEquals(year, number.getYearIssued());
		
		System.out.println("testGetYearIssued success");
	}

	@Test
	void testGetSerialNumber() throws ParseException 
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		final Name name = new Name("Mark", "Smith");
		
		final DrivingLicence dl = new DrivingLicence(name, df.parse("11-10-1995"),df.parse("01-03-2015"),true);
		
		final LicenceNumber number = new LicenceNumber(dl.getInitials(name.toString()), dl.yearIssued());
		
		final int serial = number.getSerialNumber();
		
		Assertions.assertEquals(serial, number.getSerialNumber());
		
		System.out.println("testGetSerialNumber success");
	}

}
