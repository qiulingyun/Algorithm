package Model;

import java.util.ArrayList;

public class ExcelData {
	private ArrayList<Post> postList;
	private ArrayList<TreeNode> costCenterRootList;
	private ArrayList<TreeNode> profitCenterRootList;
	private ArrayList<AccountMasterData> accountMasterDataList;
	
	
	public ExcelData() {
		super();
		postList = new ArrayList<Post>();
		costCenterRootList = new ArrayList<TreeNode>();
		profitCenterRootList = new ArrayList<TreeNode>();
		accountMasterDataList = new ArrayList<AccountMasterData>();
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



	public ArrayList<AccountMasterData> getAccountMasterDataList() {
		return accountMasterDataList;
	}



	public void setAccountMasterDataList(ArrayList<AccountMasterData> accountMasterDataList) {
		this.accountMasterDataList = accountMasterDataList;
	}

	

	
	
	
}
