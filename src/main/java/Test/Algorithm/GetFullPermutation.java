package Test.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetFullPermutation {

	private List<String> allList = Arrays.asList("a", "b", "c");
	private static List<List<String>> subList = new ArrayList<List<String>>();
	
	public void backTracking(int step, List<String> currList, List<String> leftChoiceList){
		if (step >= allList.size()) {
			List<String> list = new ArrayList<String>();
			list.addAll(currList);
			subList.add(list);
		} else {
			if (step == 0) {
				currList = new ArrayList<>();
				leftChoiceList = new ArrayList<>();
				leftChoiceList.addAll(allList);
			}
			
			for (int i = 0; i < leftChoiceList.size(); i++) {
				String s = leftChoiceList.get(i);
				currList.add(s);
				leftChoiceList.remove(i);
				backTracking(step + 1, currList, leftChoiceList);
				currList.remove(s);
				leftChoiceList.add(i, s);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetFullPermutation obj = new GetFullPermutation();
		obj.backTracking(0, null, null);
		for (List<String> list : subList) {
			System.out.println(list);
		}
		System.out.println("Number: " + subList.size());
	}

}
