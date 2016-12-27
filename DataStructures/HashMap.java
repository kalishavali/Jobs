package hashing;

public class HashMap {
	private static class HashMapEntry{
		public int key;
		public int value;
		public HashMapEntry next;
		public HashMapEntry(int key,int value,HashMapEntry next){
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	private static final double MAX_LOAD_FACTOR=0.75;
	private HashMapEntry[] hashTable;
	private int size;
	public HashMap(){
		hashTable=new HashMapEntry[10];
	}
	public int hashFunction(int key){
		return Math.abs(key)%hashTable.length;
	}
	public void put(int key,int value){
		int bucket=hashFunction(key);
		HashMapEntry current=hashTable[bucket];
		while(current!=null){
			if(current.key==key)
				break;
			current=current.next;
		}
		if(current!=null){ //Key Found
			current.value=value;
		}else{
			if(loadFactor()>=MAX_LOAD_FACTOR)
				rehash();
			hashTable[bucket]=new HashMapEntry(key,value,hashTable[bucket]);
			size++;
		}
	}
	public int get(int key){
		int bucket=hashFunction(key);
		HashMapEntry current=hashTable[bucket];
		while(current!=null){
			if(current.key==key)
				return current.value;
			current=current.next;
		}
		return -1;
	}
	public String toString(){
		String result="[";
		boolean first=true;
		for(int i=0;i<hashTable.length;i++){
			HashMapEntry current=hashTable[i];
			while(current!=null){
				if(!first)
					result+=",";
				result+="("+current.key+","+current.value+")";
				current=current.next;
				first=false;
			}
		}
		result+="]";
		return result;
	}
	public void remove(int key){
		int bucket=hashFunction(key);
		if(hashTable[bucket]!=null){
			if(hashTable[bucket].key==key){
				hashTable[bucket]=hashTable[bucket].next;
				size--;
			}else{
				HashMapEntry current=hashTable[bucket];
				while(current.next!=null && current.next.key!=key){
					current=current.next;
				}
				if(current.next!=null && current.next.key==key){
					current.next=current.next.next;
					size--;
				}
			}
		}
	}
	public boolean contains(int key){
		int bucket=hashFunction(key);
		if(hashTable[bucket]!=null){
			HashMapEntry current=hashTable[bucket];
			while(current!=null){
				if(current.key==key)
					return true;
				current=current.next;
			}
		}
		return false;
	}
	public double loadFactor(){
		return (double)size/hashTable.length;
	}
	public void rehash(){
		HashMapEntry[] oldMap=hashTable;
		hashTable=new HashMapEntry[2*hashTable.length];
		size=0;
		for(int i=0;i<hashTable.length;i++){
			HashMapEntry current=oldMap[i];
			while(current!=null){
				put(current.key,current.value);
				current=current.next;
			}
		}
	}
	public static void main(String[] args) {
		HashMap map=new HashMap();
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, 30);
		map.put(4, 40);
		System.out.println(map);
		map.remove(3);
		System.out.println(map);
	}
}
