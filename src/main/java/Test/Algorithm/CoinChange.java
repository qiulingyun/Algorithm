package Test.Algorithm;

public class CoinChange {

	
	//这里用回溯法测试递归时间复杂度，coins = {1, 2, 5}，amount = 100, 计算时间 > 5 mins
	public int coinChange1(int[] coins, int amount) {
        
		if (amount <= 0) {
			return 0;
		}
		
		int res = Integer.MAX_VALUE;
		int counter = 0;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= amount) {
				int ret = coinChange1(coins, amount - coins[i]);
				if (ret == -1) {
					counter++;
				}else {
					res = Math.min(res, ret + 1);
				}
				
			} else {
				counter++;
			}
		}
		
		if (counter == coins.length) {
			return -1;
		}
		return res;
    }
	
	// f(n)=min(f(n-a), f(n-b), f(n-c))
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		for (int i = 1; i <= amount; i++) {
			int res = Integer.MAX_VALUE;
			int counter = 0;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					if (dp[i-coins[j]] == -1) {
						counter++;
						continue;
					}
					res = Math.min(res, dp[i-coins[j]] + 1);
				}else{
					counter++;
				}
			}
			if (counter == coins.length) {
				dp[i] = -1;
				continue;
			}
			
			dp[i] = res;
		}
		return dp[amount];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange obj = new CoinChange();
		int[] coins = {1, 2, 5};
		System.out.println(obj.coinChange(coins, 100));
	}

}
