package Test.Algorithm;

import java.util.LinkedList;

public class 滑动窗口最大值 {

	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null ) {
			return null;
		}else if (nums.length == 0) {
			return new int[0];
		}
		int[] res = new int[nums.length-k+1];
		LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
			if (queue.size() == 0) {
				queue.add(nums[i]);
			}else{
				while(queue.size() > 0 && queue.getLast() < nums[i]){
					queue.pollLast();
				}
				queue.add(nums[i]);
			}
        	if (i >= k) {
				if (queue.getFirst() == nums[i-k]) {
					queue.poll();
				}
			}
        	if (i >= k-1) {
				res[i-(k-1)] = queue.peek();
			}
		}
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		滑动窗口最大值 obj = new 滑动窗口最大值();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] result = obj.maxSlidingWindow(nums, 3);
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
