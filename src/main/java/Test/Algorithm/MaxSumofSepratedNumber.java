package Test.Algorithm;

public class MaxSumofSepratedNumber {

	public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // dp[n] = max(dp[n-1], dp[n-2]+nums[n])
        for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
		}
        return dp[nums.length - 1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumofSepratedNumber obj = new MaxSumofSepratedNumber();
		int[] house = {2,7,9,3,1};
		System.out.println(obj.rob(house));
		
	}

}
