package Model;

import java.util.ArrayList;

public class ExcelData {
	private ArrayList<Post> postList;
	private ArrayList<TreeNode> costCenterRootList;
	private ArrayList<TreeNode> profitCenterRootList;
	
	
	
	public ExcelData() {
		super();
		postList = new ArrayList<Post>();
		costCenterRootList = new ArrayList<TreeNode>();
		profitCenterRootList = new ArrayList<TreeNode>();
	}



	public ArrayList<Post> getPostList() {
		return postList;
	}



	public void setPostList(ArrayList<Post> postList) {
		this.postList = postList;
	}



	public ArrayList<TreeNode> getCostCenterRootList() {
		return costCenterRootList;
	}



	public void setCostCenterRootList(ArrayList<TreeNode> costCenterRootList) {
		this.costCenterRootList = costCenterRootList;
	}



	public ArrayList<TreeNode> getProfitCenterRootList() {
		return profitCenterRootList;
	}



	public void setProfitCenterRootList(ArrayList<TreeNode> profitCenterRootList) {
		this.profitCenterRootList = profitCenterRootList;
	}

	

	
	
	
}
