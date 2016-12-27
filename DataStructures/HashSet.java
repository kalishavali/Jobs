package hashing;

public class HashSet<E> {
	private static final double MAX_LOAD_FACTOR=0.75;
	public HashEntry<E>[] hashTable;
	private int size;
	private HashSet(){
		hashTable=new HashEntry[10];
		size=0;
	}
	public int hashFunction(E value){
		return Math.abs(value.hashCode()) % hashTable.length;
	}
	public double loadFactor(){
		return (double)size/hashTable.length;
	}
	public void add(E value){
		if(!contains(value)){
			if(loadFactor()>=MAX_LOAD_FACTOR)
				rehash();
			int bucket=hashFunction(value);
			hashTable[bucket]=new HashEntry<E>(value,hashTable[bucket]);
			size++;
		}
	}
	public boolean contains(E value){
		int bucket=hashFunction(value);
		HashEntry<E> current=hashTable[bucket];
		while(current!=null){
			if(current.data.equals(value))
				return true;
			current=current.next;
		}
		return false;
	}
	public int getSize(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public String toString(){
		String result="[";
		boolean first=true;
		if(!isEmpty()){
			for(int i=0;i<hashTable.length;i++){
				HashEntry<E> current=hashTable[i];
				while(current!=null){
					if(!first)
						result+=",";
					result+=current.data;
					current=current.next;
					first=false;
				}
			}
		}
		result+="]";
		return result;
	}
	public void remove(E value){
		int bucket=hashFunction(value);
		if(hashTable[bucket]!=null){
			if(hashTable[bucket].data.equals(value)){
				hashTable[bucket]=hashTable[bucket].next;
				size--;
			}else{
				HashEntry<E> current=hashTable[bucket];
				while(current.next!=null && !current.next.data.equals(value)){
					current=current.next;
				}
				if(current.next!=null && current.next.data.equals(value)){
					current.next=current.next.next;
					size--;
				}
			}	
		}
	}
	private void rehash(){
		HashEntry<E>[] oldHashTable=hashTable;
		hashTable=new HashEntry[2*hashTable.length];
		size=0;
		for(int i=0;i<oldHashTable.length;i++){
			HashEntry<E> current=oldHashTable[i];
			while(current!=null){
				add(current.data);
				current=current.next;
			}
		}
	}
	public static void main(String[] args) {
		HashSet set=new HashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(set);
		set.remove(3);
		System.out.println(set);
	}
}
