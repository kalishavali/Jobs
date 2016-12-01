package Hackerrank;

import java.util.Scanner;

public class SumOfSeries {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		int n=console.nextInt();
		console.nextLine();
		String s=console.nextLine();
		String[] arr=s.split("\\+");
		if(arr.length==n){
			double sum=0.0;
			for(int i=1;i<=n;i++){
				sum+= (double)1/factorial(i);
			}
			System.out.println(Math.round(sum*1000000000.0)/1000000000.0);
		}
		
	}
	public static int factorial(int n){
		if(n==0)
			return 1;
		else
			return n*factorial(n-1);
	}
}
