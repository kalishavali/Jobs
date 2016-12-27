package strings;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMain {
	static boolean previousDate(){
		long prevDay=System.currentTimeMillis()-1000*60*60*24;
		Date prevDate=new Date(prevDay);
		Date current=new Date();
		if(prevDate.before(current))
			return true;
		else
			return false;	
	}
	static boolean afterDate(){
		long afterDate=System.currentTimeMillis()+1000*60*60*24;
		Date afterD=new Date(afterDate);
		Date current=new Date();
		return afterD.after(current)?true:false;
	}
	static String dateInFormat(String format){
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	public static void main(String[] args) {
		Date d=new Date();
		System.out.println("Date: "+d.getDate());
		System.out.println("Month: "+d.getMonth());
		System.out.println("Year: "+d.getYear());
		System.out.println("Day: "+d.getDay());
		System.out.println("Hours: "+d.getHours());
		boolean res1=previousDate();
		System.out.println(res1);
		boolean res2=afterDate();
		System.out.println(res2);
		String res3=dateInFormat("yyyy-MM-dd");
		System.out.println(res3);
	}
}
