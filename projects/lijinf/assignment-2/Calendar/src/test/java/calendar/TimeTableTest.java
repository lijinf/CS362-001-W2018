package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable timeTable=new TimeTable();
		 GregorianCalendar first = new GregorianCalendar();
		 GregorianCalendar last = new GregorianCalendar(2018,10,25);
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 int[] recurringDays = new int[0];
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 "",
				 "");
		 appt.setRecurrence(recurringDays, 1, 0, 1);
		 appts.add(appt);
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay + 1,
				 startMonth + 1,
				 startYear ,
				 "",
				 "");

		 appt.setRecurrence(recurringDays, 1, 0, 1);
		 appts.add(appt);
		 appt = new Appt(-1,
				 startMinute ,
				 startDay + 1,
				 startMonth + 1,
				 startYear ,
				 "",
				 "");
		 appts.add(appt);
		 timeTable.getApptRange(appts,first,last);
		 //timeTable.getApptRange(appts,last,first);

	 }
	 @Test
	  public void test02()  throws Throwable  {
		 TimeTable timeTable=new TimeTable();
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 int[] recurringDays = new int[0];
		 Appt appt = null;
		 assertNull(timeTable.deleteAppt(appts, appt));//both null
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 "",
				 "");
		 assertNull(timeTable.deleteAppt(appts, appt));//appts == null
		 appts.add(appt);
		 appt = null;
		 assertNull(timeTable.deleteAppt(appts, appt));// appt == null
		 appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 "",
				 "");
		 appts.add(appt);
		 appt.setStartHour(-1);
		 assertNull(timeTable.deleteAppt(appts, appt));
		 appt.setStartHour(21);
		 appts.add(appt);
		 appts.add(appt);
		 assertNull(timeTable.deleteAppt(appts, appt));
	 }
	 @Test
		public void test03()  throws Throwable  {
		 TimeTable timeTable=new TimeTable();
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
		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 appts.add(appt);
		 appts.add(appt);
		 int[] pv = new int[1];
		 timeTable.permute(appts,pv);
		 pv = new int[2];
		 timeTable.permute(appts,pv);
		}
//add more unit tests as you needed
}
