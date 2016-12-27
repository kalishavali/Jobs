package linkedLists;

public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }
    //Getting Head of the Element
    public ListNode getHead(){
    	return front;
    }
    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    public int getLength(ListNode a) {
		int count = 0;
		while (a != null) {
			count++;
			a = a.next;
		}
		return count;
	}
    public void MergeSort()
    {
        front=mergeSort(front);
    }
	public ListNode mergeSort(ListNode head){
		if(head.next==null)
			return head;
		
		ListNode left=head;
		int mid=getLength(head)/2;
		while(mid-1>0){
			left=left.next;
			mid--;
		}
		ListNode right=left.next;
		left.next=null;
		left=head;
		
		left=mergeSort(left);
		right=mergeSort(right);
		
		return merge(left,right);
	}
    public ListNode merge(ListNode left,ListNode right){
		if(left==null)
			return right;
		if(right==null)
			return left;
		if(left.data<right.data){
			left.next=merge(left.next,right);
			return left;
		}else{
			right.next=merge(right.next,left);
			return right;
		}
	}
    public LinkedIntList mergeLists(LinkedIntList left,LinkedIntList right){
 		ListNode current= merge(left.front,right.front);
 		LinkedIntList list=new LinkedIntList();
 		while(current!=null){
 			list.add(current.data);
 			current=current.next;
 		}
 		return list;
 	}
    public void removeDupliactes(){
    	removeDuplicates(front);
    }
    public void removeDuplicates(ListNode current){
    	if(current==null)
    		return;
    	while(current!=null && current.next!=null){
    		while(current.next!=null && current.data==current.next.data){
    			current.next=current.next.next;
    		}
    		current=current.next;
    	}
    }
    public void reverse(){
    	ListNode currNode=front;
    	ListNode nextNode=null;
    	ListNode prevNode=null;
    	while(currNode!=null){
    		nextNode=currNode.next;
    		currNode.next=prevNode;
    		prevNode=currNode;
    		currNode=nextNode;
    	}
    	front=prevNode;
    }
	public static void main(String[] args) {
		LinkedIntList list1=new LinkedIntList();
		list1.add(4);
		list1.add(3);
		list1.add(2);
		/*LinkedIntList list2=new LinkedIntList();
		list2.add(5);
		list2.add(6);
		list2.add(7);
		list2.add(8);
		LinkedIntList list3=new LinkedIntList().mergeLists(list1,list2);*/
		list1.reverse();
		System.out.println(list1);
	}
}
