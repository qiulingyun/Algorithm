package Utility;

public class AddPrefixZero {
	public static String addPrefixZero(String val, int length){
		if(val == null || length <= 0){
			return null;
		}
		
		if(val.length() >= length){
			return val;
		}
		
		int len = length - val.length();
		for(int i = 0; i < len; i++){
			val = "0" + val;
		}
		
		return val;
	}
	
	public static void main(String args[]){
		String val = "10010000";
		System.out.println(addPrefixZero(val, 10));
	}
}
