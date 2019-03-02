package TemplateMethod;

public abstract class Calculate {
	
	public final int calculate(String exp, String splitor){
		int[] num = splitApart(exp, splitor);
		return this.calculate(num);
	}
	
	public int[] splitApart(String exp, String splitor){
		int[] result = new int[]{0, 0};
		if(exp == null || exp.length() == 0 || splitor == null || splitor.length() == 0){
			return result;
		}
		
		String[] number = exp.split(splitor);
		if(number.length < 2){
			return result;
		}
		result[0] = Integer.parseInt(number[0]);
		result[1] = Integer.parseInt(number[1]);
		return result;
		
	}
	
	protected abstract int calculate(int[] num);
	

}
