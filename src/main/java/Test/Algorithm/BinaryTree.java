package Test.Algorithm;

import java.util.Stack;

public class BinaryTree {

	
	public class Node{
		public int val;
		public Node left;
		public Node right;
		
		public Node(int val){
			this.val = val;
		}

		@Override
		public String toString() {
			return "[" + val + "]";
		}

	}
	
	Node root = null;
	
	public void constructTree1(){
		root = new Node(5);
		Node a = new Node(3);
		root.left = a;
		Node b = new Node(1);
		a.left = b;
		Node c = new Node(4);
		a.right = c;
		Node d = new Node(2);
		b.right = d;
		
		Node e = new Node(7);
		root.right = e;
		Node f = new Node(6);
		e.left = f;
	}
	
	private void visit(Node node){
		System.out.print(node + " ");
	}
	
	//用深度优先遍历的思想实现
	//stack存储可被访问的节点
	public void preorder2(){
		if (root == null) {
			return;
		}
		
		Stack<Node> st = new Stack<Node>();
		st.push(root);
		System.out.println("Begin Pre-Order:");
		while (st.size() > 0) {
			Node curr = st.pop();
			visit(curr);
			if (curr.right != null) {
				st.push(curr.right);
			}
			if (curr.left != null) {
				st.push(curr.left);
			}
		}
		System.out.println();
	}
	
	public void preorder(){
		if (root == null) {
			return;
		}
		Node curr = root;
		Stack<Node> st = new Stack<Node>();
		System.out.println("Begin Pre-Order:");
		while (curr != null){
			System.out.print(curr.val + ", ");
			
			if (curr.left != null) {
				st.push(curr);
				curr = curr.left;
				
			}else if (curr.right != null) {
				st.push(curr);
				curr = curr.right;	
			}else {
				
				while (st.isEmpty() == false && (st.peek().right == null || st.peek().right == curr)) {
					st.pop();
				}
				if (st.size() != 0) {
					curr = st.peek().right;
				}else{
					curr = null;
				}
				
			}
		}

	}
	
	private Node findLeftest(Node node, Stack<Node> log){
		Node curr = node;
		while (curr.left != null) {
			log.push(curr);
			curr = curr.left;
		}
		return curr;
	}
	
	//思路：先找到最左节点，然后依次寻找当前节点的后继节点
	public void midorder2(){
		if (root == null) {
			return;
		}

		Stack<Node> st = new Stack<Node>();
		System.out.println("Begin Mid-Order:");
		
		Node curr = findLeftest(root, st);
		
		while(curr != null){
			visit(curr);
			
			//find next
			if (curr.right != null) {
				st.push(curr);
				curr = findLeftest(curr.right, st);
			}else{
				Node parent = null;
				if (st.size() > 0) {
					parent = st.pop();
				}
				while (parent != null && parent.left != curr) {
					curr = parent;
					if (st.size() > 0) {
						parent = st.pop();
					}else{
						parent = null;
					}
					
				}
				curr = parent;
			}
		}
		
		System.out.println();
	}
	
	public void midorder(){
		if (root == null) {
			return;
		}
		Node curr = root;
		Stack<Node> st = new Stack<Node>();
		System.out.println("Begin Mid-Order:");
		while (curr != null){

			if (curr.left != null) {
				st.push(curr);
				curr = curr.left;
				
			}else{
				System.out.print(curr.val + ", ");
				if (curr.right != null) {
					st.push(curr);
					curr = curr.right;	
				}else {
					while (st.isEmpty() == false && (st.peek().right == null || st.peek().right == curr)) {
						System.out.print(st.peek().val + ", ");
						st.pop();
					}
					if (st.size() != 0) {
						
						curr = st.peek().right;
					}else{
						curr = null;
					}
					
				}
			}
				
			
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.constructTree1();
		bt.preorder2();
		bt.midorder2();
	}

}
