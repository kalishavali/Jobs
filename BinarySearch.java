package Hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		String s=console.nextLine();
		int n=console.nextInt();
		String[] arr=s.split("\\,");
		for(int i=0;i<arr.length;i++){
			int target=Integer.parseInt(arr[i]);
			if(target==n){
				System.out.println("true\nposition = "+i);
			}else{
				System.out.println("false");
			}
		}
	}
	//O(logN)
}
