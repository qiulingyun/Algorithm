package Test.Algorithm;

import java.util.ArrayList;

public class LengthOfLIS {
	// 2,100,101,102,3,4,5,6,7
	public int lengthOfLIS(int[] nums) {
		/**
        dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
        由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度. 
        对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
        1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
           数组尾部, 并将最长递增序列长度maxL加1
        2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
        **/
		
		if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return 1;
		}
		
		int[] dp = new int[nums.length];
		int maxl = 0;

		for (int i = 0; i < nums.length; i++) {
			int low = 0, high = maxl;
			while (low < high) {
				int mid = (low+high)/2;
				if (nums[i] < dp[mid]) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			dp[low] = nums[i];
			if (low == maxl) {
				maxl++;
			}
		}
		
		return maxl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthOfLIS obj = new LengthOfLIS();
		int[] input = { 2, 2 };
		System.out.println(obj.lengthOfLIS(input));
	}

}
