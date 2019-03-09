package Test.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllSubCorrection {

	private List<String> allList = Arrays.asList("a", "b", "c");
	private static List<List<String>> subList = new ArrayList<List<String>>();
	
	public void backTracking(int step, List<String> currList){
		if (step >= allList.size()) {
			List<String> list = new ArrayList<String>();
			list.addAll(currList);
			subList.add(list);
		}else{
			if (step == 0) {
				currList = new ArrayList<String>();
			}
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					currList.add(allList.get(step));
					backTracking(step + 1, currList);
					currList.remove(allList.get(step));
				}else{
					backTracking(step + 1, currList);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetAllSubCorrection obj = new GetAllSubCorrection();
		obj.backTracking(0, null);
		for (List<String> list : subList) {
			System.out.println(list);
		}
		System.out.println("Number: " + subList.size());
	}

}
