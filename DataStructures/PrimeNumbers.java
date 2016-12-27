package strings;

import java.util.ArrayList;

public class PrimeNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

		for(int i = 4; primeNumbers.size()< 10; i++) {
		    boolean divisible = false;
		    for(int j=2;j<Math.sqrt(i);j++) {
		        if(i % j == 0) {
		            divisible = true;
		        }
		    }
		    if(divisible == false) {
		        primeNumbers.add(i);
		        System.out.print(i+" ");
		    }
		}
	}
}
