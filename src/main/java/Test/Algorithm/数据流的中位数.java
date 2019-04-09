package Test.Algorithm;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 数据流的中位数 {
	
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
				(Integer o1, Integer o2)->{ return o2 - o1;}
			);
//	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
//			new Comparator<Integer>() {
//				@Override
//				public int compare(Integer o1, Integer o2) {
//					return o2 - o1;
//				}
//			}
//	);
	
	
	public void addNum(int num) {
		list.add(num);
		if (maxHeap.isEmpty()) {
			maxHeap.add(num);
		}else{
			int left = maxHeap.peek();
			if (left >= num) {
				maxHeap.add(num);
				if (maxHeap.size() - minHeap.size() > 1) {
					minHeap.add(maxHeap.poll());
				}
			}else{
				minHeap.add(num);
				if (minHeap.size() - maxHeap.size() > 1) {
					maxHeap.add(minHeap.poll());
				}
			}
		}
		
    }
	
	public double findMedian() {
		if (list.size() == 0) {
			return 0;
		}else if (list.size() == 1) {
			return list.getFirst();
		}
		
		if (list.size() % 2 == 1) {
			if (minHeap.size() > maxHeap.size()) {
				return minHeap.peek();
			}
			return maxHeap.peek();
		}
        return (minHeap.peek() + maxHeap.peek()) / (2d);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		数据流的中位数 obj = new 数据流的中位数();
		obj.addNum(-1);
		System.out.println(obj.findMedian());
		obj.addNum(-2);
		System.out.println(obj.findMedian());
		obj.addNum(-3);
		System.out.println(obj.findMedian());
		obj.addNum(-4);
		System.out.println(obj.findMedian());
		obj.addNum(-5);
		System.out.println(obj.findMedian());

	}

}
