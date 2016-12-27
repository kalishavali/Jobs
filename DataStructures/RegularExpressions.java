package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
	static boolean ipRegCheck(String str){
		Pattern pattern=Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
		Matcher matcher=pattern.matcher(str);
		return matcher.find();
	}
	static boolean caseSensitiveCheck(String str){
		Pattern pattern=Pattern.compile("Java",Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher(str);
		return matcher.find();
	}
	static String removeMultipleSpaces(String str,String replace){
		Pattern pattern=Pattern.compile("\\s+");
		Matcher matcher=pattern.matcher(str);
		return matcher.replaceAll(replace);
	}
	static boolean checkUsername(String str){
		Pattern pattern=Pattern.compile("^[aA-z0-9_-]{6,14}$");
		Matcher matcher=pattern.matcher(str);
		return matcher.matches();
	}
	static boolean extMatcher(String str){
		Pattern pattern=Pattern.compile("([^\\s]+(\\.(?i)(pdf|doc|csv|mp3))$)");
		Matcher matcher=pattern.matcher(str);
		return matcher.matches();
	}
	static List<String> findIPs(String str){
		Pattern pattern=Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
		Matcher matcher=pattern.matcher(str);
		List<String> list=new ArrayList<String>();
		while(matcher.find())
			list.add(matcher.group());
		return list;
	}
	static String[] splitString(String str){
		Pattern pattern=Pattern.compile("(cat|rat|mat|bat)");
		String[] arr= pattern.split(str);
		return arr;
	}
	public static void main(String[] args) {
		boolean res1=ipRegCheck("10.23.45.12");
		System.out.println(res1);
		boolean res2=caseSensitiveCheck("JAVA");
		System.out.println(res2);
		String res3=removeMultipleSpaces("Kali    is Waste    Fellow"," ");
		System.out.println(res3);
		boolean res4=checkUsername("gukt@123");
		System.out.println(res4);
		boolean res5=extMatcher("java2novice.pdf");
		System.out.println(res5);
		List<String> res6=findIPs("Hi my machine IP is 10.20.30.40 and i would like "+
            "to access port 80 from the host 23.12.56.34, which internally"+
            "connects to 3.90.23.65. Please process the request");
		System.out.println(res6);
		String[] res7=splitString("I have a cat. I play cricket with bat. I dont like rat,"+
            "i hate mats, now break it");
		System.out.println(Arrays.toString(res7));
	}
}
