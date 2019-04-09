package Test.Algorithm;

public class MaxSumofSepratedNumber {

	private int counter = 0;
	
	public int rob1(int[] nums) {
		counter = 0;	// count
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        counter = 3;	// count
        // dp[n] = max(dp[n-1], dp[n-2]+nums[n])
        for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
			counter += 2;	// count
		}
        counter++;
        return dp[nums.length - 1];
    }
	
	public int rob2(int[] nums){
		counter = 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];
		dp[2] = nums[2] + nums[0];
		counter = 3;	// count
        // dp[n] = nums[n] + max(dp[n-2], dp[n-3])
		// dp[n] = nums[n] + max(dp[n-2], dp[n-3], dp[n-4], ..., dp[0])
        for (int i = 3; i < nums.length; i++) {
			dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
			counter += 2;	// count
		}
        counter++;
        counter++;
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumofSepratedNumber obj = new MaxSumofSepratedNumber();
		int[] house = {2,7,9,3,1,10,3,8, 18, 3,4,5};
		System.out.println(obj.rob1(house));
		System.out.println("operation: " + obj.counter);
		System.out.println(obj.rob2(house));
		System.out.println("operation: " + obj.counter);
	}

}
