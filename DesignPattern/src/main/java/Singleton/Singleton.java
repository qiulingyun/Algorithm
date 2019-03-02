package Singleton;

public class Singleton {
	private static Singleton instance = null;

	private Singleton() {
	};

	public static Singleton getInstance() throws InterruptedException {

		if (instance == null) {
			Thread.sleep(3000);
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}

		}

		return instance;
	}
}
