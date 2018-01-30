package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay calday_null = new CalDay();
		 assertFalse(calday_null.isValid());
		 assertNull(calday_null.iterator());
		 CalDay calday = new CalDay(cal);
		 assertTrue(calday.isValid());
		 assertEquals(calday.getDay(),cal.get(cal.DAY_OF_MONTH));
		 assertEquals(calday.getMonth(),cal.get(cal.MONTH));
		 assertEquals(calday.getYear(),cal.get(cal.YEAR));
		 assertEquals(0,calday.getSizeAppts());
		 assertFalse(calday.iterator() == null);
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay calday = new CalDay(cal);
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 "",
				 "");
		 appt.setStartHour(-1);
		 calday.addAppt(appt);
		 appt.setStartHour(21);
		 calday.addAppt(appt);

	 }
	 @Test
		public void test03()  throws Throwable  {
		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay calday_null = new CalDay();
		 calday_null.toString();
		 CalDay calday = new CalDay(cal);
		 calday.toString();
	 }
//add more unit tests as you needed	
}
