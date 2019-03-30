package Test.Algorithm;

import java.util.HashSet;

public class LongestConsecutive {
	
	public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		
		int result = 0;
		for (int i : nums) {
			if (set.remove(i)) {
				int left = i - 1, right = i + 1;
				while(set.remove(left)){
					left--;
				};
				while(set.remove(right)){
					right++;
				};
				result = Math.max(result, right - left - 1);
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsecutive obj = new LongestConsecutive();
		int[] input = {100, 4, 200, 1, 3, 2};
		System.out.println(obj.longestConsecutive(input));
	}

}
