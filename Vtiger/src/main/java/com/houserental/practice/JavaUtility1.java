package com.houserental.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility1 {
	Random ran=new Random();
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	  /**
	   * used to get the random number from the 1 to 4000;
	   * @return
	   */
	public int getRandomNumber() {
		int value = ran.nextInt(4000);
		return value;
	}
	/**
	 * used to get the random phone number
	 * @return
	 */
	public long getRandomPhoneNumber() {
		String s="";
		long number=0l;
		for(int i=0;i<10;i++) {
			int no = ran.nextInt(10);
			s=s+no;			
		}
		 number = Long.parseLong(s);
		 return number;
	}
	/**
	 * used to get the current date in the system
	 * @return
	 */
	public String getDate() {
		String date1 = sim.format(date);
		return date1;
	}
	/**
	 * used to get the required date
	 * @param requiredDate
	 * @return
	 */
	public String getDate(int requiredDate) {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, requiredDate);
		Date time = cal.getTime();
		String format = sim.format(time);
		return format;
		
	}

}
