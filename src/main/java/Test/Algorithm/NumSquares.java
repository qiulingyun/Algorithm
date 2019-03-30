package Test.Algorithm;

import java.util.HashMap;

public class NumSquares {

	public int numSquares(int n) {
        HashMap<Integer, Integer> dpMap = new HashMap<>();
        dpMap.put(0, 0);
        dpMap.put(1, 1);
        return _numSquares2(n, dpMap);
    }
	
	public int _numSquares1(int n, HashMap<Integer, Integer> dpMap){
		if (dpMap.containsKey(n)) {
			return dpMap.get(n);
		}
		
		int res = Integer.MAX_VALUE;
		for (int i = 1; i * i <= n; i++) {
			res = Math.min(res, _numSquares1(n - i * i, dpMap) + 1);
		}
		dpMap.put(n, res);
		return res;
	}
	
	public int _numSquares2(int n, HashMap<Integer, Integer> dpMap){
		for (int i = 2; i <= n; i++) {
			int res = Integer.MAX_VALUE;
			for (int j = 1; j*j <= i; j++) {
				res = Math.min(res, dpMap.get(i - j*j) + 1);
			}
			dpMap.put(i, res);
		}
		return dpMap.get(n);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumSquares obj = new NumSquares();
		System.out.println(obj.numSquares(12));
	}

}
