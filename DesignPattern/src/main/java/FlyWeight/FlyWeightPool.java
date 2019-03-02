package FlyWeight;

import java.util.ArrayList;
import java.util.Vector;

public class FlyWeightPool {
	private Vector<FlyWeight> pool;
	private static FlyWeightPool instance;
	private final int NUM = 2;

	private FlyWeightPool() {
		super();
		pool = new Vector<FlyWeight>(NUM);
		for(int i = 0; i < NUM ;i++){
			pool.add(new FlyWeight(i, "" + i, new ArrayList<String>()));
		}
	}
	
	public static FlyWeightPool getInstance(){
		synchronized (FlyWeightPool.class) {
			if(instance == null){
				instance = new FlyWeightPool();
			}
		}
		return instance;
	}
	
	public synchronized FlyWeight getFlyWeight(){
		if(pool.size() > 0){
			FlyWeight flywWeight = pool.lastElement();
			pool.remove(flywWeight);
			return flywWeight;
		}
		return null;
	}
	
	public synchronized void releaseFlyWeight(FlyWeight flyWeight){
		if(flyWeight == null && pool.size() < NUM){
			pool.add(new FlyWeight());
		}else if(flyWeight != null && pool.size() < NUM){
			pool.add(flyWeight);
		}
	}
	
	
}
