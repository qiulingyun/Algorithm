package Test.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class DP_CutRope_muliply {

	private static final int LENGTH = 20;
	private static final int STEP = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		HashMap<Integer, ArrayList<Integer>> multiplyMap = new HashMap<Integer, ArrayList<Integer>>();
		
		for (int j = 1; j <= LENGTH; j = j + STEP) {
			int max = -1;
			for(int i = 1; i <= j; i = i + STEP ){
				int temp = -1;
				if (i == j && temp < i ) {
					temp = i;
				}else{
					if (resultMap.containsKey(j-i)) {
						temp = i * resultMap.get(j-i);
					}else{
						System.out.println("Error!");
					}
					
				}
				if(max <= temp){
					max = temp;
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(0, i);
					if (i != j) {
						list.addAll(multiplyMap.get(j-i));
					}
					
					multiplyMap.put(j, list);
				}
			}
			resultMap.putIfAbsent(j, max);
			System.out.println("Length=" + j + ", max multiply:" + max + ", way:" + multiplyMap.get(j));
		}
		
	}
	
	public static boolean dequals(int a, int b){
		if (Math.abs(a-b) < 0.000001) {
			return true;
		}
		return false;
	}

}
