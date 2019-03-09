package Test.Algorithm;

public class Bag0_1 {
	
	private final int SIZE = 3;
	private final int[] WEIGHTS = {10,8,5};
	private final int[] VALUES = {5,4,1};
	private final int BAGVOLUMN = 16;
	
	private int[] currentChoice = new int[3];
	private int currentWeight = 0;
	private int currentValue = 0;
	
	private static int bestValue = 0;
	private static int[] bestChoice = new int[3];
	
	/**
	 * 
	 * @param step: level of decistion tree, start by 0
	 */
	public void backTracking(int step){
		if (step >= 3) {
			if (currentValue > bestValue) {
				bestValue = currentValue;
				for (int i = 0; i < SIZE; i++) {
					bestChoice[i] = currentChoice[i];
				}
			}
		} else {
			// 0 = get, 1 = unget
			for (int i = 0; i <= 1; i++) {
				currentChoice[step] = i;
				if (i == 0) {
					if (BAGVOLUMN >= currentWeight + WEIGHTS[step]) {
						currentWeight += WEIGHTS[step];
						currentValue += VALUES[step];
						backTracking(step + 1);
						currentWeight -= WEIGHTS[step];
						currentValue -= VALUES[step];
					}
				} else {
					backTracking(step + 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag0_1 obj = new Bag0_1();
		obj.backTracking(0);
		System.out.print("Best Choice: ");
		for (int i : bestChoice) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("Best Value: " + bestValue);
	}

}
