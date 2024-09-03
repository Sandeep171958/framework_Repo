package PracticeBasics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasics {

	public static void main(String[] args) {
		Date dateobj=new Date();
		
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dateobj);
		System.out.println("Actual date : " + actDate);
		
		
		Calendar ca1=sim.getCalendar();
		ca1.add(Calendar.DAY_OF_MONTH,30);
		String dateRequires = sim.format(ca1.getTime());
		
		System.out.println("30 days before : " + dateRequires);
		
		

	}

}
