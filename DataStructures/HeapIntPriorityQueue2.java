package hashing;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class HeapIntPriorityQueue2 {
	private int[] heap;
	private int size;
	public HeapIntPriorityQueue2(){
		heap=new int[10];
		size=0;
	}
	public int parent(int index){
		return index/2;
	}
	public boolean hasParent(int index){
		return index>1;
	}
	public void add(int value){
		if((size+1)>=heap.length)
			Arrays.copyOf(heap,2*heap.length);
		heap[size+1]=value;
		int index=size+1;
		while(hasParent(index)){
			int parent=parent(index);
			if(heap[index]<heap[parent]){
				swap(heap,index,parent(index));
				index=parent(index);
			}else{
				break;
			}
		}
		size++;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public int peek(){
		if(isEmpty())
			throw new NoSuchElementException();
		return heap[1];
	}
	private boolean hasLeftChild(int index){
		return leftChild(index)<=size;
	}
	private boolean hasRightChild(int index){
		return rightChild(index)<=size;
	}
	private int leftChild(int index){
		return 2*index;
	}
	private int rightChild(int index){
		return 2*index+1;
	}
	public void swap(int[] a,int index1,int index2){
		int temp=a[index1];
		a[index1]=a[index2];
		a[index2]=temp;
	}
	private int size(){
		return size;
	}
	private void bubbleDown(int index){
		while(hasLeftChild(index)){
			int left=leftChild(index);
			int right=rightChild(index);
			int child=left;
			if(hasRightChild(index) && heap[right]<heap[left])
				child=right;
			if(heap[index]>heap[child]){
				swap(heap,index,child);
				index=child;
			}else{
				break;
			}
		}
	}
	public int remove(){
		int result=peek();
		swap(heap,1,size);
		size--;
		bubbleDown(1);
		return result;
	}
	public String toString(){
		String result="[";
		if(!isEmpty()){
			result+=+heap[1];
			for(int i=2;i<heap.length;i++){
				result+=","+heap[i];
			}
		}
		result+="]";
		return result;
	}
	public static void heapSort(int[] a) {
        HeapIntPriorityQueue2 pq = new HeapIntPriorityQueue2();
        pq.heap = a;
        pq.size = a.length-1;
        
        System.out.println("start : " + Arrays.toString(a));
        
        for (int i = a.length / 2; i >= 0; i--) {
            pq.bubbleDown(i);
            System.out.println("bubble: " + Arrays.toString(a));
        }
        while (!pq.isEmpty()) {
            pq.remove();
            System.out.println("remove: " + Arrays.toString(a));
        }
    }
	public static void main(String[] args) {
		heapSort(new int[]{5, 50, 20, 90, 44, 60, 80, 70, 99, 10});
	}
}
