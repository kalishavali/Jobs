package Hackerrank;

import java.util.Scanner;

public class NthFibanocci {
	  public static long fibonacci(int n) {
	        if (n <= 1) return n;
	        else return fibonacci(n-1) + fibonacci(n-2);
	    }

	    public static void main(String[] args) {
	        Scanner console=new Scanner(System.in);
	        int n=console.nextInt();
	        System.out.print(0);
	        for (int i = 1; i <= n; i++)
	            System.out.print(" "+fibonacci(i));
	        System.out.println("\n"+fibonacci(n));
	    }
}
