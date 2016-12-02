package Hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner console=new Scanner(System.in);
		String s=console.nextLine();
		int target=console.nextInt();
		
		String[] arr=s.split("\\,");
		int[] nums=new int[arr.length];
		for(int i=0;i<arr.length;i++)
			nums[i]=Integer.parseInt(arr[i]);
		
		int position=-1;
		for(int j=0;j<nums.length;j++){
				if(nums[j]==target)
					position=j;
		}
		
		Arrays.sort(nums);
		System.out.println(binarySearch(nums,target)+"\nposition = "+position);
		
	}
	//O(N)
	static boolean binarySearch(int[] numbers,int target){
		int min=0;
		int max=numbers.length-1;
		while(min<=max){
			int mid=(min+max)/2;
			if(numbers[mid]<target){
				min=mid+1;
			}else if(numbers[mid]>target){
				max=mid-1;
			}else if(numbers[mid]==target){
				return true;
			}
		}
		return false;
	}
	//O(logN)
}
