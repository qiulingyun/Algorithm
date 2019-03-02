package Singleton;

public class MultiThreadTester extends Thread {

	@Override
	public void run() {
		try {
			System.out.println(this.getId() + ": " + Singleton.getInstance().hashCode());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiThreadTester[] threadPool = new MultiThreadTester[10];
		for(int i = 0; i < threadPool.length; i++){
			threadPool[i] = new MultiThreadTester();
		}
		
		for(int i = 0; i < threadPool.length; i++){
			threadPool[i].start();
		}
	}

}
