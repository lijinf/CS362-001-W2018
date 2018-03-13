package calendar;


import org.junit.Test;
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	//private static final long TestTimeout = 5000;
	private static final int NUM_TESTS=10;
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...CalDay()");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				GregorianCalendar cal = new GregorianCalendar();
				long randomseed = System.currentTimeMillis(); //10
				Random random = new Random(randomseed);
				CalDay calday = new CalDay(cal);
				int startHour = 21;
				int startMinute = 30;
				int startDay = 15;
				int startMonth = 01;
				int startYear = 2018;
				String title = "Birthday Party";
				String description = "This is my birthday party.";
				Appt appt = new Appt(startHour,
						startMinute,
						startDay,
						startMonth,
						startYear,
						title,
						description);
				int newHour = ValuesGenerator.getRandomIntBetween(random, 0, 23);
				appt.setStartHour(newHour);
				calday.addAppt(appt);
				for(int i=0;i<NUM_TESTS;i++) {
					Appt appt_later = new Appt(startHour,
							startMinute,
							startDay,
							startMonth,
							startYear,
							title,
							description);
					int randomPlus = ValuesGenerator.getRandomIntBetween(random, -3, 3);
					appt_later.setStartHour(newHour + randomPlus);
					calday.addAppt(appt_later);
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 }
		 }catch(NullPointerException e){

		 }
		 System.out.println("Done testing...");
	 }


	
}
