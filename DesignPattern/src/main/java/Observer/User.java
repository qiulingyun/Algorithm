package Observer;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject sub = new SubjectImpl();
		sub.addObserver(new ObserverImpl());
		sub.addObserver(new ObserverImpl());
		sub.operation();
	}

}
