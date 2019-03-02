package Mediator;

public class User2 extends AbstractUser {

	public User2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User2(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work() {
		System.out.println("In User2, work");

	}

}
