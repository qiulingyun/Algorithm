package Suggestion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Model.ExcelData;
import Model.Header;
import Model.LineItem;
import Model.Post;
import Model.TreeNode;
import Utility.TreeHelper;

public class PostSuggestion {
	public void calculateSimilarity(Post left, Post right){
		
	}
	
	public double calSimilarityByFiscalYear(Header left, Header right) throws ParseException{
		if(left == null || right == null){
			return -1d;
		}
		String leftFiscalYear = left.getFiscalYear();
		String rightFiscalYear = right.getFiscalYear();
		
		if(leftFiscalYear == null || rightFiscalYear == null){
			return -1d;
		}
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date leftDate = sdf.parse(leftFiscalYear);
		Date rightDate = sdf.parse(rightFiscalYear);
		Calendar leftCalendar = Calendar.getInstance();
		leftCalendar.setTime(leftDate);
		Calendar rightCalendar = Calendar.getInstance();
		rightCalendar.setTime(rightDate);
		
		double dateDiff = Math.abs(leftCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) - rightCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		double monthDiff = Math.abs(leftCalendar.get(Calendar.MONTH) - rightCalendar.get(Calendar.MONTH));
//		int yearDiff = Math.abs(leftCalendar.get(Calendar.YEAR) - rightCalendar.get(Calendar.YEAR));
		return (1-(dateDiff/30 + monthDiff/11)/2);
	}
	
	public double calSimilarityByCostCenterTree(LineItem left, LineItem right, ExcelData excel){
		if(left == null || right == null || excel == null){
			return -1d;
		}
		String leftCostCenter = left.getCostCenter();
		String rightCostCenter = left.getCostCenter();
		ArrayList<TreeNode> costCenterRootList = excel.getCostCenterRootList();
		TreeNode leftRoot = null, leftNode = null;
		TreeNode rightRoot = null, rightNode = null;
		for(int i = 0; i < costCenterRootList.size(); i++){
			TreeNode root = costCenterRootList.get(i);
			leftNode = TreeHelper.find(root, leftCostCenter);
			if(leftNode != null){
				leftRoot = root;
				break;
			}
		}
		for(int i = 0; i < costCenterRootList.size(); i++){
			TreeNode root = costCenterRootList.get(i);
			rightNode = TreeHelper.find(root, rightCostCenter);
			if(rightNode != null){
				rightRoot = root;
				break;
			}
		}
		if(leftNode == null && rightNode == null){
			return 1d;
		}else if(leftNode == null || rightNode == null){
			return 0d;
		}
		
		if(leftRoot.getName() != rightRoot.getName()){
			return 0d;
		}
		
		double treeLevel = TreeHelper.getTreeLevel(leftRoot);
		return (1-(double)Math.abs(leftNode.getLevel() - rightNode.getLevel())/treeLevel);
	}
	
	public double calSimilarityByProfitCenterTree(LineItem left, LineItem right, ExcelData excel){
		if(left == null || right == null || excel == null){
			return -1d;
		}
		String leftProfitCenter = left.getProfitCenter();
		String rightProfitCenter = left.getProfitCenter();
		ArrayList<TreeNode> profitCenterRootList = excel.getProfitCenterRootList();
		TreeNode leftRoot = null, leftNode = null;
		TreeNode rightRoot = null, rightNode = null;
		for(int i = 0; i < profitCenterRootList.size(); i++){
			TreeNode root = profitCenterRootList.get(i);
			leftNode = TreeHelper.find(root, leftProfitCenter);
			if(leftNode != null){
				leftRoot = root;
				break;
			}
		}
		for(int i = 0; i < profitCenterRootList.size(); i++){
			TreeNode root = profitCenterRootList.get(i);
			rightNode = TreeHelper.find(root, rightProfitCenter);
			if(rightNode != null){
				rightRoot = root;
				break;
			}
		}
		if(leftNode == null && rightNode == null){
			return 1d;
		}else if(leftNode == null || rightNode == null){
			return 0d;
		}
		
		if(leftRoot.getName() != rightRoot.getName()){
			return 0d;
		}
		
		double treeLevel = TreeHelper.getTreeLevel(leftRoot);
		return (1-(double)Math.abs(leftNode.getLevel() - rightNode.getLevel())/treeLevel);
	}
}
