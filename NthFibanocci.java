package Hackerrank;

import java.util.Scanner;

public class NthFibanocci {
	  public static void main(String[] args) {
	        Scanner console=new Scanner(System.in);
	        int n=console.nextInt();
	        int a=0;
	        int b=1;
	        System.out.print(a+" "+b);
	        for (int i = 3; i <= n; i++){
	        	int c=a+b;
	        	a=b;
	        	b=c;
	        	System.out.print(" "+c);
	        }
	        System.out.print("\n"+b);
	    }
}
