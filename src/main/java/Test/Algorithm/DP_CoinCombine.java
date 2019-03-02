package Test.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DP_CoinCombine {

	private final int[] COINS = { 1, 3, 5 };

	public ArrayList<Integer> getCoinCombine(int sum) {
		if (sum <= 0) {
			return null;
		}
		HashMap<Integer, ArrayList<Integer>> ret = new HashMap<Integer, ArrayList<Integer>>();
		ret.put(1, new ArrayList<Integer>(Arrays.asList(1)));
		for (int i = 2; i <= sum; i++) {
			int minNum = Integer.MAX_VALUE;
			ArrayList<Integer> minCombinList = null;
			for (int j = 0; j < COINS.length && COINS[j] <= i; j++) {
				if (COINS[j] == i) {
					minNum = 1;
					minCombinList = new ArrayList<Integer>();
					minCombinList.add(COINS[j]);
					break;
				}

				ArrayList<Integer> jList = ret.get(COINS[j]);
				ArrayList<Integer> leftList = ret.get(i - COINS[j]);

				int tempSize = jList.size() + leftList.size();
				if (tempSize < minNum) {
					minNum = tempSize;
					minCombinList = new ArrayList<Integer>();
					minCombinList.addAll(jList);
					minCombinList.addAll(leftList);
				}

			}

			ret.put(i, minCombinList);
		}

		return ret.get(sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_CoinCombine dp = new DP_CoinCombine();
		for (int i = 3; i < 20; i++) {
			System.out.print(i + ": ");
			System.out.println(dp.getCoinCombine(i));
		}

	}

}
