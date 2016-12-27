package ArraysPckg;

import java.util.ArrayList;
import java.util.Collections;

public class CalendarDate implements Comparable<CalendarDate>{
	private int month;
	private int day;
	public CalendarDate(int month,int day){
		this.month=month;
		this.day=day;
	}
	public int compareTo(CalendarDate Other){
		if(month!=Other.month)
			return month-Other.month;
		else
			return day-Other.day;
	}
	public int getMonth(){
		return month;
	}
	public int getDay(){
		return day;
	}
	public String toString(){
		return month+"/"+day;
	}
	public static void main(String[] args) {
		ArrayList<CalendarDate> dates =
				new ArrayList<CalendarDate>();
				dates.add(new CalendarDate(2, 22)); // Washington
				 dates.add(new CalendarDate(10, 30)); // Adams
				 dates.add(new CalendarDate(4, 13)); // Jefferson
				 dates.add(new CalendarDate(3, 16)); // Madison
				 dates.add(new CalendarDate(4, 28)); // Monroe
				System.out.println("birthdays = " + dates);
				 Collections.sort(dates);
				 System.out.println("birthdays = " + dates);
				
	}

}
