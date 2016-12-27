package strings;

import java.util.StringTokenizer;

public class StringTokenizerMain {
	public static void main(String[] args) {
		String msg="I Love Jesus";
		String msg1="http://10.123.43.67:80/";
		StringTokenizer tokens=new StringTokenizer(msg," ");
		StringTokenizer tokens2=new StringTokenizer(msg1,"://.");
		// Using De-limiters also part of String
		StringTokenizer tokens3=new StringTokenizer(msg1,"://.",true);
		// Token Count
		tokens.countTokens();
		
		while(tokens2.hasMoreTokens()){
			System.out.println(tokens2.nextToken());
		}
	}
}
