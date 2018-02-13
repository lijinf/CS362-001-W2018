package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	 // Appt()
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
		 assertEquals(2,appt.getRecurBy());
		 assertEquals(0,appt.getRecurIncrement());
		 assertEquals(0,appt.getRecurNumber());
	 }

	 @Test
	 // isValid()
	  public void test02()  throws Throwable  {
	 	 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());
		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
		 appt.setStartHour(0);
		 assertTrue(appt.getValid());
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());

		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(60);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());

		 appt.setStartDay(0);
		 assertFalse(appt.getValid());
		 appt.setStartDay(32);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(31);
		 assertTrue(appt.getValid());

		 appt.setStartMonth(12);
		 assertTrue(appt.getStartMonth() == 12);
		 appt.setStartMonth(01);
		 assertTrue(appt.getStartMonth() == 01);

		 appt.setStartYear(0);
		 assertTrue(appt.getStartYear() == 0);
		 appt.setStartYear(2018);
		 assertTrue(appt.getStartYear() == 2018);

		 appt.setTitle(null);
		 assertEquals("",appt.getTitle());
		 appt.setTitle(title);
		 assertEquals(title,appt.getTitle());
		 appt.setDescription(null);
		 assertEquals("",appt.getDescription());
		 appt.setDescription(description);
		 assertEquals(description,appt.getDescription());

	 }
	 @Test
	 // toSorting()
	  public void test03()  throws Throwable {
	 	 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 Appt appt = new Appt(startHour,
		 		startMinute ,
		 		startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		 appt.setStartHour(-1);
		 assertEquals(-1,appt.getStartHour());
		 assertNull(appt.toString());
		 appt.setStartHour(21);
		 assertEquals(21,appt.getStartHour());
		 assertFalse(appt.toString() == null);
	  }
	@Test
	public void test04()  throws Throwable {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		int[] recurringDays = new int[0];
		appt.setRecurrence(recurringDays, 2, 0, 0);
		assertEquals(0, appt.getRecurIncrement());
		assertEquals(0, appt.getRecurNumber());
		assertEquals(2, appt.getRecurBy());
		assertEquals(recurringDays, appt.getRecurDays());
		assertFalse(appt.isRecurring());
		appt.setRecurrence(null, 2, 0, 0);
		assertEquals(0, appt.getRecurIncrement());
		assertEquals(0, appt.getRecurNumber());
		assertEquals(2, appt.getRecurBy());
		assertTrue(appt.getRecurDays() != null);
		assertFalse(appt.isRecurring());
	}
	@Test
	// compareTo()
	public void test05()  throws Throwable {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		Appt comAppt = new Appt(startHour-1,
				startMinute-1 ,
				startDay-1 ,
				startMonth+1 ,
				startYear-1 ,
				title,
				description);
		assertEquals(3,appt.compareTo(comAppt));
	}
//add more unit tests as you needed
	
}
