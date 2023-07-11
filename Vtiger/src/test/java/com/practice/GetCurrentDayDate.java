package com.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetCurrentDayDate {
	public static void main(String[] args) {
	/*	Date d=new Date();
		System.out.println(d);
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String format = sim.format(d);
		System.out.println(format);*/
		 
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 10);
		Date time = cal.getTime();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String format = sim.format(time);
		System.out.println(format);
		
		
	}

}
