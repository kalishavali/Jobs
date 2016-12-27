package hashing;

import java.util.Arrays;

public class MaxHeap {
	private int[] heap;
	private int size;
	public MaxHeap(){
		heap=new int[10];
		size=0;
	}
	public int getSize(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public int parent(int index){
		return index/2;
	}
	public int leftChild(int index){
		return 2*index;
	}
	public int rightChild(int index){
		return 2*index+1;
	}
	public boolean hasParent(int index){
		return index>1;
	}
	public boolean hasLeftChild(int index){
		return leftChild(index)<=size;
	}
	public boolean hasRightChild(int index){
		return rightChild(index)<=size;
	}
	public void swap(int[] a,int index1,int index2){
		int temp=a[index1];
		a[index1]=a[index2];
		a[index2]=temp;
	}
	public void add(int value){
		if( (size+1)>=heap.length)
			heap=Arrays.copyOf(heap, 2*heap.length);
		heap[size+1]=value;
		//Bubble Up
		int index=size+1;
		boolean found=false;
		while(hasParent(index) && !found){
			int parent=parent(index);
			if(heap[index]>heap[parent]){
				swap(heap,index,parent(index));
				index=parent(index);
			}else{
				found=true;
			}
		}
		size++;
	}
	public void remove(){
		
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
		MaxHeap maxh=new MaxHeap();
		int[] values={50, 30, 15, 19, 20, 10, 5, 2};
		for(int n:values){
			maxh.add(n);
			System.out.println(maxh);
		}
		System.out.println(maxh);
	}
}
