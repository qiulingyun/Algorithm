package Utility;

import java.util.ArrayList;
import Model.TreeNode;

public class TreeHelper {

	public static TreeNode find(TreeNode root, String target){
		if(root == null){
			return null;
		}
		String name = root.getName();
		if(name != null && name.equals(target)){
			return root;
		}
		ArrayList<TreeNode> children = root.getChildren();
		if(children == null){
			return null;
		}
		for(int i = 0; i < children.size(); i++){
			TreeNode node = find(children.get(i), target);
			if(node != null){
				return node;
			}
		}
		return null;
	}
	
	public static ArrayList<TreeNode> findByLevel(TreeNode root, int level){
		if(root == null){
			return null;
		}
		int nodeLevel = root.getLevel();
		if(nodeLevel == level){
			ArrayList<TreeNode> list = new ArrayList<TreeNode>();
			list.add(root);
			return list;
		}
		ArrayList<TreeNode> children = root.getChildren();
		if(children == null || children.isEmpty()){
			return null;
		}
		
		ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
		for(int i = 0; i < children.size(); i++){
			ArrayList<TreeNode> list = findByLevel(children.get(i), level);
			if(list != null){
				ret.addAll(list);
			}
		}
		return ret;
	}
	
	public static TreeNode findRoot(TreeNode node){
		if(node == null){
			return null;
		}
		TreeNode parent = node.getParent();
		if(parent == null){
			return node;
		}
		TreeNode ret = findRoot(parent);
		if(ret != null){
			return ret;
		}
		return null;
	}
	
	public static ArrayList<TreeNode> findAllLeafNode(TreeNode root){
		if(root == null){
			return null;
		}
		
		ArrayList<TreeNode> children = root.getChildren();
		if(children == null || children.isEmpty()){
			ArrayList<TreeNode> leafList = new ArrayList<TreeNode>();
			leafList.add(root);
			return leafList;
		}
		ArrayList<TreeNode> retList = new ArrayList<TreeNode>();
		for(int i = 0; i < children.size(); i++){
			ArrayList<TreeNode> list = findAllLeafNode(children.get(i));
			if(list != null){
				retList.addAll(list);
			}
		}
		return retList;
		
	}
	
	public static int getTreeLevel(TreeNode root){
		if(root == null){
			return -1;
		}
		
		int level = 0;
		ArrayList<TreeNode> leafList = findAllLeafNode(root);
		for(int i = 0; i < leafList.size(); i++){
			TreeNode node = leafList.get(i);
			int nodeLevel = node.getLevel();
			if(nodeLevel > level){
				level = nodeLevel;
			}
		}
		return level;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.setLevel(0);
		
		TreeNode sub11 = new TreeNode();
		sub11.setParent(root);
		sub11.setLevel(1);
		root.getChildren().add(sub11);
		
		TreeNode sub12 = new TreeNode();
		sub12.setParent(root);
		sub12.setName("v12");
		sub12.setLevel(1);
		root.getChildren().add(sub12);
		
		TreeNode sub21 = new TreeNode();
		sub21.setParent(sub11);
		sub11.getChildren().add(sub21);
		sub21.setName("v21");
		sub21.setLevel(2);
		TreeNode sub22 = new TreeNode();
		sub22.setParent(sub11);
		sub11.getChildren().add(sub22);
		sub22.setName("target");
		sub22.setLevel(2);
		TreeNode sub23 = new TreeNode();
		sub23.setParent(sub12);
		sub12.getChildren().add(sub23);
		sub23.setLevel(2);
		
		TreeNode answer = find(root, "target");
		System.out.println(answer.getName());
		
		ArrayList<TreeNode> list = findByLevel(root, 1);
		System.out.println(list);
		
		
		System.out.println(findRoot(sub22));

		System.out.println(findAllLeafNode(root));
		
		System.out.println(getTreeLevel(root));
	}

}
