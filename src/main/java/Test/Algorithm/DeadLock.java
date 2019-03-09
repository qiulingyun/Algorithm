package Test.Algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLock {

	private String s1 = "o1";
	private String s2 = "02";
	
	class A implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName() + "try to lock:" + s1 + "...");
			synchronized (s1) {
				System.out.println(Thread.currentThread().getName() + "has get lock:" + s1);
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "try to lock:" + s2 + "...");
				synchronized (s2) {
					System.out.println(Thread.currentThread().getName() + "has get lock:" + s2);
				}
			}
		}
	}
	
	class B implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName() + "try to lock:" + s2 + "...");
			synchronized (s2) {
				System.out.println(Thread.currentThread().getName() + "has get lock:" + s2 + "!");
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "try to lock:" + s1 + "...");
				synchronized (s1) {
					System.out.println(Thread.currentThread().getName() + "has get lock:" + s1 + "!");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeadLock dl = new DeadLock();
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(dl.new A());
		es.execute(dl.new B());
		es.shutdown();
		
	}

}
