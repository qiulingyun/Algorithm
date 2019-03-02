package Composite;

public class Tree {
	private String treeName;
	private Node root;
	
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public Tree() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tree(String treeName, Node root) {
		super();
		this.treeName = treeName;
		this.root = root;
	}
	
	
}
