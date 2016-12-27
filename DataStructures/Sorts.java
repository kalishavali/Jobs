package linkedLists;

import java.util.Arrays;

public class Sorts {
	public static void selectionSort(int[] a){
		for(int i=0;i<a.length-1;i++){
			int smallest=i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[smallest])
					smallest=j;
			}
			swap(a,i,smallest);
		}
	}
	public static void swap(int[] a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void merge(int[] result,int[] left,int[] right){
		System.out.println("merging " + Arrays.toString(left) +
				" and " + Arrays.toString(right));
		int iL=0;
		int iR=0;
		for(int i=0;i<result.length;i++){
			if( (iR>=right.length) ||(iL<left.length && left[iL]<=right[iR]) ){
				result[i]=left[iL];
				iL++;
			}else{
				result[i]=right[iR];
				iR++;
			}
		}
		System.out.println("merging Both " + Arrays.toString(result));
	}
	public static void mergeSort(int[] a){
		System.out.println("sorting " + Arrays.toString(a));
		if(a.length>1){
			int[] left=Arrays.copyOfRange(a,0,a.length/2);
			int[] right=Arrays.copyOfRange(a,a.length/2,a.length);
			mergeSort(left);
			mergeSort(right);
			merge(a,left,right);
		}
	}
	
	public static void main(String[] args) {
		int[] a={3,1,4,2,7,5};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}
}
