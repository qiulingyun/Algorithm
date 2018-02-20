package Model;

import java.util.ArrayList;

public class TreeNode {
	private int level;
	private String name;
	private ArrayList<TreeNode> children;
	private TreeNode parent;
	
	public TreeNode() {
		super();
		parent = null;
		children = new ArrayList<TreeNode>();
	}

	public TreeNode(int level, String name, ArrayList<TreeNode> children, TreeNode parent) {
		super();
		this.level = level;
		this.name = name;
		this.children = children;
		this.parent = parent;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<TreeNode> children) {
		this.children = children;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "(" + level + ": " + name + ")";
	}
	
	
}
