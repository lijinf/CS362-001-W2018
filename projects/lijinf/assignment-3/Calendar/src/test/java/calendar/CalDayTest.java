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
	 // CalDay()
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
	 // addAppt()
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
		 Appt appt_later = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 "",
				 "");
		 appt.setStartHour(-1);
		 calday.addAppt(appt);
		 assertEquals(0,calday.getAppts().size());
		 appt.setStartHour(15);
		 appt_later.setStartHour(16);
		 calday.addAppt(appt);
		 calday.addAppt(appt_later);
		 assertEquals(appt,calday.getAppts().get(0));
		 assertEquals(appt_later,calday.getAppts().get(1));
		 appt.setStartHour(14);
		 calday.addAppt(appt);
		 assertEquals(appt,calday.getAppts().get(0));
		 appt.setStartHour(15);
		 assertEquals(appt,calday.getAppts().get(1));
		 assertEquals(appt_later,calday.getAppts().get(2));
	 }
	 @Test
	 // toString()
		public void test03()  throws Throwable  {
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
		 GregorianCalendar cal = new GregorianCalendar();
		 CalDay calday_null = new CalDay();
		 assertEquals("",calday_null.toString());
		 CalDay calday = new CalDay(cal);
		 calday.addAppt(appt);
		 appt.setStartHour(5);
		 calday.addAppt(appt);
		 assertFalse(calday.toString() == "");
		 CalDay calday_next = new CalDay();
		 calday.addAppt(appt);
		 appt.setStartHour(21);
		 calday.addAppt(appt);
		 assertFalse(calday.toString() == calday_next.toString());
	 }
//add more unit tests as you needed	
}
