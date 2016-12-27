package linkedLists;

public class ListClient2 {
	private static class Node{
		public int data;
		public Node next;
		public Node(){
			this(0,null);
		}
		public Node(int value,Node next){
			this.data=value;
			this.next=next;
		}
	}
	public static Node merge(Node left,Node right){
		if(left==null)
			return right;
		if(right==null)
			return right;
		if(left.data<right.data){
			left.next=merge(left.next,right);
			return left;
		}else{
			right.next=merge(right.next,left);
			return right;
		}
	}
	public static Node mergeSort(Node head){
		if(head.next==null)
			return head;
		else{
			Node left=head;
			Node right=head.next.next.next;
			while(right!=null){
				head=head.next;
				right=right.next.next;
			}
			right=head.next;
			head.next=null;
			left=mergeSort(left);
			right=mergeSort(right);
			return merge(left,right);
		}
		
	}
	public static void main(String[] args) {
		LinkedIntList list1=new LinkedIntList();
		list1.add(1);
		list1.add(4);
		list1.add(2);
		list1.add(3);
		list1.mergeLists();
		System.out.println(result);
	}
}
