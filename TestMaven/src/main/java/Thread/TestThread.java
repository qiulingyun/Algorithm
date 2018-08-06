package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {
	public static void main(String[] args){
		Sender sender = new Sender();
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 10; i++){
			executor.execute(sender);
			System.out.println(i + "=============");
		}
		
	}
}
