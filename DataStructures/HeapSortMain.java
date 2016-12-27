package hashing;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSortMain {
	public static void heapSort(int[] a){
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		for(int n:a){
			pq.add(n);
		}
		for(int i=0;i<a.length;i++){
			a[i]=pq.remove();
		}
	}
	public static void main(String[] args) {
		int[] a = {0, 65, 50, 20, 90, 44, 60, 80, 70, 99, 10};
        heapSort(a);
        System.out.println(Arrays.toString(a));
	}
}
