package hashing;

public class HashEntry<E> {
	public E data;
	public HashEntry next;
	
	public HashEntry(E data,HashEntry next){
		this.data=data;
		this.next=next;
	}
}
