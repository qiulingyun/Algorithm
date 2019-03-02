package Test.Algorithm;

import java.util.ArrayList;

public class Solution {


	
	int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p <= l/2; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
//		int[] input = {2147483647, -2147483648, 0, 0, -1, 1, -1, 1};
		int input = Integer.parseInt("1",2);
		System.out.println(input);
		System.out.println(Integer.toBinaryString(input));
		
		System.out.println(s.solution(input));
		
	}

}
