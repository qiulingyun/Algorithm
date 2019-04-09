package Test.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class 前K个高频元素 {

	public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
			Integer value = map.get(i);
        	if (value == null) {
				value = new Integer(1);
			}else{
				value = value + 1;
			}
        	map.put(i, value);
		}
        
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
        		(o1, o2)->{ return o1.getValue()-o2.getValue(); }
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (heap.size() < k) {
				heap.add(entry);
			}else{
				Map.Entry<Integer, Integer> top = heap.peek();
				if (top.getValue() < entry.getValue()) {
					heap.poll();
					heap.add(entry);
				}
			}
		}
        
        List<Integer> retList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : heap) {
        	retList.add(entry.getKey());
		}
        return retList;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		前K个高频元素 obj = new 前K个高频元素();
		int[] nums = {1,1,1,2,2,3};
		System.out.println(obj.topKFrequent(nums, 2));
	}

}
