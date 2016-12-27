package strings;

import java.util.Random;

public class RandomStringMain {
	private static final String Char_List="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	
	private static String randomString(){
		Random rand=new Random();
		String result="";
		for(int i=0;i<6;i++)
			result+=Char_List.charAt(rand.nextInt(Char_List.length()));
		return result;
	}
	
	public static void main(String[] args) {
		String res1=randomString();
		System.out.println(res1);
	}
}
