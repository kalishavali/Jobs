package hashing;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
	private int[] heap;
	private int size;
	public MinHeap(){
		heap=new int[10];
		size=0;
	}
	private int parent(int index){
		return index/2;
	}
	private int leftChild(int index){
		return index*2;
	}
	private int rightChild(int index){
		return index*2+1;
	}
	private boolean hasParent(int index){
		return index>1;
	}
	private boolean hasLeftChild(int index){
		return leftChild(index)<=size;
	}
	private boolean hasRightChild(int index){
		return rightChild(index)<=size;
	}
	public void swap(int[] a,int index1,int index2){
		int temp=a[index1];
		a[index1]=a[index2];
		a[index2]=temp;
	}
	public void add(int value){
		
		//if size is less than 
		if( size+1 >= heap.length )
			heap=Arrays.copyOf(heap, 2*heap.length);
		
		heap[size+1]=value; //add as rightmost leaf
		
		// "bubble up" as necessary
		int index=size+1;
		boolean found=false;
		while( hasParent(index) && !found ){
			int parent=parent(index);
			if( heap[index] < heap[parent] ){
				swap(heap,index,parent(index));
				index=parent(index);
			}else{
				found=true;
			}
		}
		size++;
	}
	private boolean isEmpty(){
		return size==0;
	}
	private int peek(){
		if(isEmpty())
			throw new NoSuchElementException();
		return heap[1];
	}
	public int remove(){
		int result=peek();
		//move rightmost leaf to root
		heap[1]=heap[size];
		size--;
		//"bubble down" as necessary
		int index=1;
		boolean found=false;
		while(hasLeftChild(index) && !found){
			int left=leftChild(index);
			int right=rightChild(index);
			int child=left;
			if(hasRightChild(index) && heap[right]<heap[left]){
				child=right;
			}
			if(heap[index]>heap[child]){
				swap(heap,index,child);
				index=child;
			}else{
				found=true;
			}
		}
		return result;
	}
	private int size(){
		return size;
	}
	public String toString(){
		String result="[";
		if(!isEmpty()){
			result+=heap[1];
			for(int i=2;i<=size;i++){
				result+=","+heap[i];
			}
		}
		result+="]";
		return result;
	}
	
	public static void main(String[] args) {
		MinHeap hpq=new MinHeap();
		int[] values={65, 50, 20, 90, 44, 60, 80, 70, 99, 10};
		for(int n:values){
			hpq.add(n);
		}
		System.out.println(hpq);
		while(!hpq.isEmpty()){
			System.out.println(hpq.remove());
		}
	}
	
}
