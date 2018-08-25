package Test.Algorithm;

import java.util.Arrays;

public class HeapSort {

	private final int HEAPLENGTH = 255;
	private int[] heap = new int[HEAPLENGTH];
	private int size;
	
	public HeapSort() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HeapSort(int[] heap, int size) {
		super();
		this.size = size;
		this.heap = Arrays.copyOf(heap, size);
	}

	public int getParent(int p){
		if(p <= 0 || p >= size){
			throw new IndexOutOfBoundsException();
		}
		return heap[(p+1)/2-1];
	}
	public int getLeftChild(int p){
		if(p < 0 || p >= size || 2*(p+1)-1 >= size ){
			throw new IndexOutOfBoundsException();
		}
		return heap[2*(p+1)-1];
	}
	public int getRightChild(int p){
		if(p < 0 || p >= size || 2*(p+1) >= size ){
			throw new IndexOutOfBoundsException();
		}
		return heap[2*(p+1)];
	}
	public boolean isLeaf(int p){
		try {
			getLeftChild(p);
		} catch (Exception e) {
			return true;
		}
		return false;

	}
	
	public void maxHeapify(int p){
	
		int leftChild;
		try{
			leftChild = getLeftChild(p);
		}catch(IndexOutOfBoundsException e){
			return;
		}
		int rightChild;
		try {
			rightChild = getRightChild(p);
		} catch (IndexOutOfBoundsException e) {
			rightChild = Integer.MIN_VALUE;
		}
		
		int position;
		int max;
		if(leftChild > rightChild){
			max = leftChild;
			position = 2 * (p + 1) - 1;
		}else{
			max = rightChild;
			position = 2 * (p + 1);
		}
		
		int current = heap[p];
		if(current < max){
			heap[p] = max;
			heap[position] = current;
			maxHeapify(position);
		}
		
	}
	
	public void constructMaxHeap(){
		int beginIndex = size / 2 - 1;
		for (int i = beginIndex; i >= 0; i--) {
			maxHeapify(i);
		}
	}
	
	public void heapSort(){
		while (size > 1) {
			int beginIndex = size / 2 - 1;
			for (int i = beginIndex; i >= 0; i--) {
				maxHeapify(i);
				
			}
			int temp = heap[0];
			heap[0] = heap[size - 1];
			heap[size - 1] = temp;
			size--;
		}
		
	}
	
	public void printArray(){
		System.out.print("\n Array:");
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + ", ");
		}
		
	}
	
	public static void main(String[] args){
		int[] input = {1,7,5, 6,3,7,12,6,9,9};
		HeapSort heapSort = new HeapSort(input, input.length);
		heapSort.printArray();
		heapSort.constructMaxHeap();
		heapSort.printArray();
		heapSort.heapSort();
//		for (int i = 0; i < input.length; i++) {
//			heapSort.maxHeapify(i);
//		}
		heapSort.printArray();
	}
}


