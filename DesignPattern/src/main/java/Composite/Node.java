package Composite;

import java.util.Vector;

public class Node {
	private String name;
	private String value;
	private Node parent;
	private Vector<Node> children;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Vector<Node> getChildren() {
		return children;
	}
	public void setChildren(Vector<Node> children) {
		this.children = children;
	}
	
	public Node() {
		super();
		name = new String();
		value = new String();
		parent = null;
		children = new Vector<Node>();
	}
	
	public void appendChildren(Node node){
		children.addElement(node);
	}
	
	public Node getSingleChildren(int index){
		return children.get(index);
	}
	
	@Override
	public String toString() {
		return "Node [name=" + name + ", value=" + value + "]";
	}
	
    
}