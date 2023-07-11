package com.houserental.genericutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * contains java specific utility
 * 
 * @author Sachin
 *
 */
public class JavaUtility {
	Random random=new Random();
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy/MM/dd");


	/**
	 * used to read random number from 1 to 4000
	 * @return
	 */
	public int getRandomNumber() {
		int value = random.nextInt(100);
		return value;
	}
	/**
	 * used to get the system current date in "yyyy-MM-dd " format 
	 * @return
	 */
	public String getDate() {
		
		String format = sim.format(date);
		return format;
		
	}
	/**
	 * used to get the required date in "yyyy-MM-dd " 
	 * format requiredDateCount is positive number , it provides upcoming date based numeric count
	 * if requiredDateCount is negative number , it provides previous date based numeric count
	 * 
	 * @param requiredDateCount
	 */
	
	public String getDate(int requiredDateCount) {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, requiredDateCount);
		Date time = cal.getTime();
		String data = sim.format(time);
		return data;
		
	}
	/**
	 * used to get the random phone number
	 * @return
	 */
	public long getRandomPhoneNumber() {
		String s="";
		long number=0l;
		for(int i=0;i<10;i++) {
			int no = random.nextInt(10);
			s=s+no;			
		}
		 number = Long.parseLong(s);
		 return number;
	}

}
