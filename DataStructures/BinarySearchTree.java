package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	
		private IntTreeNode overallRoot;

	    // pre : max > 0
	    // post: constructs a sequential tree with given number of
	    //       nodes
	    public BinarySearchTree() {
	        overallRoot=null;
	    }

	    // post: prints the tree contents using a preorder traversal
	    public void printPreorder() {
	        System.out.print("preorder:");
	        printPreorder(overallRoot);
	        System.out.println();
	    }

	    // post: prints the tree contents using a preorder traversal
	    // post: prints in preorder the tree with given root
	    private void printPreorder(IntTreeNode root) {
	        if (root != null) {
	            System.out.print(" " + root.data);
	            printPreorder(root.left);
	            printPreorder(root.right);
	        }
	    }

	    // post: prints the tree contents using a inorder traversal
	    public void printInorder() {
	        System.out.print("inorder:");
	        printInorder(overallRoot);
	        System.out.println();
	    }

	    // post: prints in inorder the tree with given root
	    private void printInorder(IntTreeNode root) {
	        if (root != null) {
	            printInorder(root.left);
	            System.out.print(" " + root.data);
	            printInorder(root.right);
	        }
	    }

	    // post: prints the tree contents using a postorder traversal
	    public void printPostorder() {
	        System.out.print("postorder:");
	        printPostorder(overallRoot);
	        System.out.println();
	    }

	    // post: prints in postorder the tree with given root
	    private void printPostorder(IntTreeNode root) {
	        if (root != null) {
	            printPostorder(root.left);
	            printPostorder(root.right);
	            System.out.print(" " + root.data);
	        }
	    }

	    // post: prints the tree contents, one per line, following an
	    //       inorder traversal and using indentation to indicate
	    //       node depth; prints right to left so that it looks
	    //       correct when the output is rotated.
	    public void printSideways() {
	        printSideways(overallRoot, 0);
	    }

	    // post: prints in reversed preorder the tree with given
	    //       root, indenting each line to the given level
	    private void printSideways(IntTreeNode root, int level) {
	        if (root != null) {
	            printSideways(root.right, level + 1);
	            for (int i = 0; i < level; i++) {
	                System.out.print("    ");
	            }
	            System.out.println(root.data);
	            printSideways(root.left, level + 1);
	        }
	    }
	    public int height(){
	    	return height(overallRoot);
	    }
	    private int height(IntTreeNode root){
	    	if(root==null){
	    		return 0;
	    	}else{
	    		return 1+Math.max(height(root.left),height(root.right));
	    	}
	    }
	    public void printLevelOrder(){
	    	int h=height(overallRoot);
	    	for(int i=0;i<=h;i++){
	    		printLevelOrder(overallRoot,i);
	    		System.out.println();
	    	}
	    }
	    private void printLevelOrder(IntTreeNode root,int level){
	    	if(root!=null){
	    		if(level==0)
	    			System.out.print(root.data+" ");
	    		else{
	    			printLevelOrder(root.left,level-1);
	    			printLevelOrder(root.right,level-1);
	    		}
	    	}
	    }
	    public void add(int value){
	    	overallRoot=add(overallRoot,value);
	    }
	    private IntTreeNode add(IntTreeNode root,int value){
	    	if(root==null)
	    		root=new IntTreeNode(value);
	    	else{
	    		if(value<=root.data)
	    			root.left=add(root.left,value);
	    		else
	    			root.right=add(root.right,value);
	    	}
	    	return root;
	    }
	    public void BFS(){
	    	BFS(overallRoot);
	    }
	    private void BFS(IntTreeNode root){
	    	if(root==null)
	    		return;
	    	Queue<IntTreeNode> q=new LinkedList<IntTreeNode>();
	    	q.add(root);
	    	while(!q.isEmpty()){
	    		IntTreeNode node=q.remove();
	    		if(node.left!=null)
	    			q.add(node.left);
	    		if(node.right!=null)
	    			q.add(node.right);
	    		System.out.print(" "+node.data);
	    	}
	    }
	    public void DFS(){
	    	DFS(overallRoot);
	    }
	    private void DFS(IntTreeNode root){
	    	if(root==null)
	    		return;
	    	Stack<IntTreeNode> s=new Stack<IntTreeNode>();
	    	s.push(root);
	    	while(!s.isEmpty()){
	    		IntTreeNode node=s.pop();
	    		if(node.right!=null)
	    			s.push(node.right);
	    		if(node.left!=null)
	    			s.push(node.left);
	    		System.out.print(" "+node.data);
	    	}
	    }
	    public static void main(String[] args) {
			BinarySearchTree bst=new BinarySearchTree();
			bst.add(42);
			bst.add(9);
			bst.add(18);
			bst.add(55);
			bst.add(7);
			bst.add(108);
			bst.add(4);
			bst.add(70);
			bst.add(203);
			bst.add(15);
			bst.printSideways();
			bst.printLevelOrder();
			bst.BFS();
			System.out.println();
			bst.DFS();
		}
	
}
