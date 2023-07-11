package com.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReadDateInCustom {
	
	public static void main(String[] args) {
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		String format = sim.format(date);
		System.out.println(format);
		
		
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,10);
		Date time = cal.getTime();
		String format2 = sim.format(time);
		System.out.println(format2);
	}

}
