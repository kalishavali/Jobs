package HakerRank;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Dates {
	static String[] reformatDate(String[] dates) throws ParseException{
		int i=0;
		for(String date:dates){
			Scanner scan=new Scanner(date);
			String dateD=scan.next();
			String dateM=scan.next();
			String dateY=scan.next();
			switch(dateM){
			case "Jan": 
				dateM="01";
				break;
			case "Feb": 
				dateM="02";
				break;
			case "Mar": 
				dateM="03";
				break;
			case "Apr": 
				dateM="04";
				break;
			case "May": 
				dateM="05";
				break;
			case "Jun": 
				dateM="06";
				break;
			case "Jul": 
				dateM="07";
				break;
			case "Aug": 
				dateM="08";
				break;
			case "Sep": 
				dateM="09";
				break;
			case "Oct": 
				dateM="10";
				break;
			case "Nov": 
				dateM="11";
				break;
			case "Dec": 
				dateM="12";
				break;
			}
			dates[i]=dateY+"-"+dateM+"-"+String.format("%02d",((Number)NumberFormat.getInstance().parse(dateD)).intValue());
			i++;
		}
		return dates;
	}
	public static void main(String[] args) throws ParseException {
		String[] s=reformatDate(new String[]{"20th Oct 2052","6th Jun 1933","26th May 1960",
				"20th Sep 1958","16th Mar 2068","25th May 1912","16th Dec 2018","26th Dec 2061","4th Nov 2030","28th Jul 1963"});
		System.out.println(Arrays.toString(s));
	}
}
