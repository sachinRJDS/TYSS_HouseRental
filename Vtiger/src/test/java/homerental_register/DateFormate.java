package homerental_register;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormate {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String format = sim.format(date);
		System.out.println(format);

		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,-10);
		Date d=cal.getTime();
		System.out.println(d);
	}

}
