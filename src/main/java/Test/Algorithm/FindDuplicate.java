package Test.Algorithm;

public class FindDuplicate {

	public int findDuplicate2(int[] nums){
		int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2, cnt = 0;
            for (int num : nums) {
                if (num <= mid) ++cnt;
            }
            if (cnt <= mid) left = mid + 1;
            else right = mid;
        }    
        return right;
	}
	
	public int findDuplicate(int[] nums) {
		int res = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int bit = (1 << i), cnt1 = 0, cnt2 = 0;
            for (int k = 0; k < n; ++k) {
                if ((k & bit) > 0) ++cnt1;
                if ((nums[k] & bit) > 0) ++cnt2;
            }
            if (cnt2 > cnt1) res += bit;
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindDuplicate obj = new FindDuplicate();
		int[] nums = {1,3,4,2,4};
		System.out.println(obj.findDuplicate(nums));
	}

}
