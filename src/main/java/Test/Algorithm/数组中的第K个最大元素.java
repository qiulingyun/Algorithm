package Test.Algorithm;

public class 数组中的第K个最大元素 {
	
	public void minHeapify(int[] nums, int size){
		if (nums == null || nums.length <= 1) {
			return;
		}
		for (int i = nums.length/2-1; i >= 0; i--) {
			keepMinHeap(nums, size, i);
		}
	}
	
	public void keepMinHeap(int[] nums, int size, int curr){
		if (curr >= size/2) {
			return;
		}
		
		int left = (curr+1)*2-1;
		int right = (curr+1)*2;
		int posi;
		if (right >= size) {
			posi = left;
		}else{
			posi = nums[left] <= nums[right] ? left: right;
		}
		if (nums[curr] <= nums[posi]) {
			return;
		}
		int temp = nums[curr];
		nums[curr] = nums[posi];
		nums[posi] = temp;
		keepMinHeap(nums, size, posi);
	}

	public int findKthLargest(int[] nums, int k) {
		minHeapify(nums, k);
		for (int i = k; i < nums.length; i++) {
			if (nums[0] < nums[i]) {
				nums[0] = nums[i];
				keepMinHeap(nums, k, 0);
			}
		}
		return nums[0];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		数组中的第K个最大元素 obj = new 数组中的第K个最大元素();
		int[] nums = {3,2,3,1,2,4,5,5,6};
		System.out.println(obj.findKthLargest(nums, 4));
	}

}
