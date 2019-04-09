package Test.Algorithm;

public class GetMedium {

	public int getMedium(int[] input){
		int heapSize = (input.length + 1) / 2;
		minHeapify(input, heapSize);
		for (int i = heapSize; i < input.length; i++) {
			if (input[0] < input[i]) {
				input[0] = input[i];
				keepMinHeap(input, heapSize, 0);
			}
		}
		return input[0];
	}
	
	public void minHeapify(int[] in, int size){
		if (size <= 1) {
			return;
		}
		for (int i = size/2 - 1; i >= 0 ; i--) {
			keepMinHeap(in, size, i);
		}
	}
	
	private void keepMinHeap(int[] in, int size, int position){
		if (size <= 1) {
			return;
		}
		// first leaf index size/2
		if (position > size/2-1) {
			return;
		}
		int left = (position + 1) * 2 - 1;
		int right = (position + 1) * 2;
		int posi = in[left] <= in[right] ? left : right;
		if (in[position] > in[posi]) {
			int temp = in[position];
			in[position] = in[posi];
			in[posi] = temp;
		}else{
			return;
		}
		keepMinHeap(in, size, posi);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMedium obj = new GetMedium();
		int[] input = { 2, 9, 4, 3, 7};
		System.out.println(obj.getMedium(input));
		
		obj.minHeapify(input, input.length);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.println();
	}

}
