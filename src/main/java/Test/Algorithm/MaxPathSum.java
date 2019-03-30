package Test.Algorithm;

public class MaxPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int result = Integer.MIN_VALUE;
	
	public int _maxPathSum(TreeNode root){
		if (root == null) {
			return 0;
		}
		int left = Math.max(_maxPathSum(root.left), 0);
		int right = Math.max(_maxPathSum(root.right), 0);
		int sumPath = Math.max( left + root.val, right + root.val);
		result = Math.max(result, left + right + root.val);
		return sumPath;
	}
	
	public int maxPathSum(TreeNode root) {
		_maxPathSum(root);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPathSum obj = new MaxPathSum();
		// System.out.println(obj.maxPathSum(root));
	}

}
