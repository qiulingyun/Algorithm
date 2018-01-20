package Composite;

import java.util.Vector;

public class User {

	public static void main(String[] args) {
		Tree tree = new Tree("mytree", new Node());
		Node root = tree.getRoot();
		root.setName("root");
		root.setValue("root");
		
		Node leaf1 = new Node();
		leaf1.setName("leaf1");
		leaf1.setValue("1");
		leaf1.setParent(root);
		root.appendChildren(leaf1);
		
		Node leaf2 = new Node();
		leaf2.setName("leaf2");
		leaf2.setValue("2");
		leaf2.setParent(root);
		root.appendChildren(leaf2);
		
		Node branch = new Node();
		branch.setName("branch");
		branch.setValue("3");
		branch.setParent(root);
		root.appendChildren(branch);
		
		Node leaf3 = new Node();
		leaf3.setName("leaf3");
		leaf3.setValue("4");
		leaf3.setParent(branch);
		branch.appendChildren(leaf3);
		
		checkTree(root);

	}
	
	public static void checkTree(Node node){
		System.out.println(node);
		Vector<Node> children = node.getChildren();
		if(children != null){
			for(int i = 0; i < children.size(); i++){
				checkTree(children.get(i));
			}
		}
	}

}
