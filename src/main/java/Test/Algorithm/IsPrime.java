package Test.Algorithm;

public class IsPrime {

	private static boolean isPrime(int src) {
		double sqrt = Math.sqrt(src);
		if (src < 2) {
			return false;
		}
		if (src == 2 || src == 3) {
			return true;
		}
		if (src % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= sqrt; i+=2) {
			if (src % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int FindNextPrime(int i){
		int j = i + 1;
		while (!isPrime(j)) {
			j++;
		}
		return j;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FindNextPrime(8));
	}

}
