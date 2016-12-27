package stacksQueues;



public class MergeLinkedLists {
	private static class Node{
		public int data;
		public Node next;
		public Node(){
			this(0,null);
		}
		public Node(int data){
			this(data,null);
		}
		public Node(int data,Node next){
			this.data=data;
			this.next=next;
		}
	}
	
 	private Node front;
 	
 	public MergeLinkedLists(){
 		front=null;
 	}
	public void add(int value){
 		if(front==null)
 			front=new Node(value);
 		else{
	 		Node current=front;
	 		while(current!=null){
	 			current=current.next;
	 		}
	 		current.next=new Node(value);
 		}
 	}
 	public void merge(MergeLinkedLists left,MergeLinkedLists right){
 		System.out.println(left.front.data);
 		System.out.println(right.front.data);
 		/*Node current= merge(left.front,right.front);
 		MergeLinkedLists list=new MergeLinkedLists();
 		while(current!=null){
 			list.add(current.data);
 			current=current.next;
 		}
 		return list;*/
 	}
 	public Node merge(Node left,Node right){
 		if(left==null)
 			return right;
 		if(right==null)
 			return left;
 		if(left.data<right.data){
 			left.next=merge(left.next,right);
 			return left;
 		}else{
 			right.next=merge(left,right.next);
 			return right;
 		}
 	}
 	public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            Node current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
 	public static void main(String[] args) {
 		MergeLinkedLists list1=new MergeLinkedLists();
 		list1.add(5);
 		list1.add(6);
 		list1.add(7);
 		list1.add(8);
 		/*MergeLinkedLists list2=new MergeLinkedLists();
 		list2.add(1);
 		list2.add(2);
 		list2.add(3);
 		list2.add(4);
 		MergeLinkedLists list3=new MergeLinkedLists();
 		list3.merge(list1, list2);*/
 		System.out.println(list1);
 		
	}
}
