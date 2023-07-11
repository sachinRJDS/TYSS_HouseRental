package com.practice;

import com.houserental.genericutility.JavaUtility;

public class GetDate {
	public static void main(String[] args) {
		JavaUtility j=new JavaUtility();
		int randomNumber = j.getRandomNumber();
		System.out.println(randomNumber);
		
		String date = j.getDate();
		System.out.println(date);
		
		String date2 = j.getDate(30);
		System.out.println(date2);
	}

}
