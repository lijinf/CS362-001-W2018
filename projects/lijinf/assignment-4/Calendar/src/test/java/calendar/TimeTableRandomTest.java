package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	//private static final long TestTimeout = 10000;
	private static final int NUM_TESTS=10;

		public static int randomYear(Random r){
			int year;
			year = ValuesGenerator.getRandomIntBetween(r, 2000, 3000);
			return year;
		}

		public static int randomMonth(Random r){
			int month;
			month = ValuesGenerator.getRandomIntBetween(r, 1, 12);
			return month;
		}

		public static int randomDay(Random r, int year, int month){
			int day;
			int DaysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			if(year%4 == 0 && month == 2){
				day = ValuesGenerator.getRandomIntBetween(r, 1, 29);
			}else if(year%4 != 0 && month == 2){
				day = ValuesGenerator.getRandomIntBetween(r, 1, 28);
			}else{
				day = DaysInMonth[month - 1];
			}
			return day;
		}
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...CalDay()");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed = System.currentTimeMillis(); //10
				 Random random = new Random(randomseed);
				 TimeTable timeTable=new TimeTable();
				 LinkedList<Appt> appts = new LinkedList<Appt>();
				 LinkedList<Appt> appts_d = new LinkedList<Appt>();

				 Appt appt = null;
				 int startHour = 12;
				 int startMinute = 30;
				 int startYear = 2018;
				 int startMonth = 2;
				 int startDay;
				 String title = "Birthday Party";
				 String description = "This is my birthday party.";
				 //test deleteAppt()
				 timeTable.deleteAppt(null, appt);
				 timeTable.deleteAppt(null, null);
				 timeTable.deleteAppt(appts, null);
				 for(int i=0;i<20;i++){
					 int coin;
					 startDay = randomDay(random, startYear, startMonth);
					 appt = new Appt(startHour,
							 startMinute,
							 startDay,
							 startMonth,
							 startYear,
							 title,
							 description);
					 appts_d.add(appt);
					 appts_d.add(appt);
					 coin = ValuesGenerator.getRandomIntBetween(random, 0, 4);
					 if(coin == 0){
						 appt.setStartHour(-1);
						 timeTable.deleteAppt(appts_d, appt);
					 }
				 }
				 for(int i=0;i<28;i++){
					 startDay = i+1;
					 appt = new Appt(startHour,
							 startMinute,
							 startDay,
							 startMonth,
							 startYear,
							 title,
							 description);
					 timeTable.deleteAppt(appts_d, appt);
				 }

				 //test getApptRange()
				 for(int i=0;i<10;i++){
					 startHour = ValuesGenerator.getRandomIntBetween(random, 1, 60);
					 startMinute = ValuesGenerator.getRandomIntBetween(random, 1, 60);
					 startYear = randomYear(random);
					 startMonth = randomMonth(random);
					 startDay = randomDay(random, startYear, startMonth);
					 appt = new Appt(startHour,
							 startMinute,
							 startDay,
							 startMonth,
							 startYear,
							 title,
							 description);
					 appts.add(appt);
				 }

				 GregorianCalendar first = new GregorianCalendar(2000,1,1);
				 GregorianCalendar last = new GregorianCalendar(3000,12,31);

				 timeTable.getApptRange(appts, first, last);
				 timeTable.getApptRange(appts, last, first);

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 //if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 }
		 }catch(NullPointerException e){

		 }
		 System.out.println("Done testing...");
	 }


	
}
