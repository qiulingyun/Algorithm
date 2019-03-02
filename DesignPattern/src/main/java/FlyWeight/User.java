package FlyWeight;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlyWeightPool pool = FlyWeightPool.getInstance();
		FlyWeight flyWeight = pool.getFlyWeight();
		if(flyWeight != null){
			System.out.println(flyWeight);
		}
		
		FlyWeightPool pool2 = FlyWeightPool.getInstance();
		FlyWeight flyWeight2 = pool.getFlyWeight();
		if(flyWeight2 != null){
			System.out.println(flyWeight2);
		}
		
		FlyWeightPool pool3 = FlyWeightPool.getInstance();
		FlyWeight flyWeight3 = pool.getFlyWeight();
		if(flyWeight3 != null){
			System.out.println(flyWeight3);
		}
	}

}
