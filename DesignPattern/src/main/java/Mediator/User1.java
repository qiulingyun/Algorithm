package Mediator;

public class User1 extends AbstractUser {

	public User1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User1(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work() {
		System.out.println("In User1, work");
	}

}
