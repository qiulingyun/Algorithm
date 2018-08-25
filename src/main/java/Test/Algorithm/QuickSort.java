package Test.Algorithm;

public class QuickSort {

	public int[] a;
	

	public QuickSort(int[] a) {
		super();
		this.a = a;
	}
	
	public int partition(int begin, int end){
		int partition = begin - 1;
		int current;
		for (current = begin; current < end; current++) {
			if (a[current] <= a[end]) {
				partition++;
				int temp = a[partition];
				a[partition] = a[current];
				a[current] = temp;
			}
		}
		int t = a[partition + 1];
		a[partition + 1] = a[end];
		a[end] = t;
		return partition + 1;
	}
	
	public void quickSort(int begin, int end){
		if (begin < end) {
			int target = this.partition(begin, end);
			this.quickSort(begin, target - 1);
			this.quickSort(target + 1, end);
		}
		
	}
	
	public void print(){
		System.out.print("Array: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+", ");
		}
		System.out.println("");
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {6,3,8,6,7,12,6,4,9,43,0};
		QuickSort qs = new QuickSort(input);
		qs.print();
		qs.quickSort(0, input.length-1);
		qs.print();
	}

}
