package Mediator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mediator mediator = new MediatorImpl();
		mediator.InitMediator();
		mediator.workAll();
	}

}
