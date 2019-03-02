package Test.Algorithm;

import java.util.Arrays;
import java.util.List;

public class TestDetectTemp {

	private final double FREZZPOINT = 0f;
	private final double BOILPOINT = 100f;
	private final double FLOATING = 0.5f;

	public void detectTemperature(List<Double> input) {
		if (input == null || input.isEmpty()) {
			return;
		}
		Double prev = null;
		boolean freezed = false;
		System.out.println(); // TODO
		for (int i = 0; i < input.size(); i++) {
			double curr = input.get(i);
			System.out.print(String.valueOf(curr) + ' '); // TODO
			if ((freezed == false) && ((prev == null && curr <= FREZZPOINT)
					|| (prev != null && prev >= FREZZPOINT + FLOATING && curr <= FREZZPOINT))) {

				System.out.print("freezing "); // TODO
				freezed = true;
			}
			if (freezed && (prev != null && prev <= FREZZPOINT + FLOATING && curr > FREZZPOINT + FLOATING)) {

				System.out.print("unfreezing "); // TODO
				freezed = false;
			}
			if ((prev == null && curr >= BOILPOINT)
					|| (prev != null && prev <= BOILPOINT - FLOATING && curr >= BOILPOINT)) {

				System.out.print("boiling "); // TODO
			}

			prev = curr;
		}
	}

	public static void main(String[] args) {
		TestDetectTemp util = new TestDetectTemp();
		
		List<Double> testList1 = Arrays.asList(4.0, 1.0, 0.5, 0.0, -0.5, 0.0, 0.5, 0.0, -2.0, 0.0, 0.5, 0.6, 2.0);
		util.detectTemperature(testList1);
		
		List<Double> testList2 = Arrays.asList(5.0, -0.5, 0.5, -0.2, 100.0, 101.0);
		util.detectTemperature(testList2);
		
		List<Double> testList3 = Arrays.asList(0.0, 0.3, 0.5, 0.4, 0.7);
		util.detectTemperature(testList3);
	}

}
