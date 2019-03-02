package Test.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class App 
{
	private ConcurrentHashMap<String, Object> store = new ConcurrentHashMap<String, Object>();
	private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	private static  ConcurrentHashMap<String, Long> validKeyMap = new ConcurrentHashMap<String, Long>();
	private static Timer cleanerTimer = new Timer();
	
	static{
		TimerTask  task = new TimerTask (){
            public void run() {
            	for (Map.Entry<String, Long> entry : validKeyMap.entrySet()) {
					if (System.currentTimeMillis() > entry.getValue()) {
						validKeyMap.remove(entry.getKey());
					
					}
				}
            	
            }
        };
        cleanerTimer.schedule (task, 0, 10000L);
	}
	
	public void cleanExpiredKey(){
		for (Map.Entry<String, Long> entry : validKeyMap.entrySet()) {
			if (entry.getValue() < System.currentTimeMillis()) {
				store.remove(entry.getKey());
				validKeyMap.remove(entry.getKey());
			}
		}
	}
	
	public void put(String key, Object value){
		final String key1 = key;
		final Object value1 = value;
		cachedThreadPool.execute(new Runnable() {
			public void run(){
				store.put(key1, value1);
				
				validKeyMap.put(key1, System.currentTimeMillis() + 10000L);
				
//				Timer timer = new Timer();
//                TimerTask  task = new TimerTask (){
//	                public void run() {
//	                	validKeyMap.put(key1, false);
//	                }
//                };
//                timer.schedule (task, 0, 10000L);
			}
		});

	}

	
	public Object get(String key){
		if (validKeyMap.get(key) > System.currentTimeMillis()) {
			return store.get(key);
		}else{
			store.remove(key);
			return null;
		}
		
	}
	

}
