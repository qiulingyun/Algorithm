package Mediator;

public abstract class AbstractUser {
	protected Mediator mediator;

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public AbstractUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractUser(Mediator mediator) {
		super();
		this.mediator = mediator;
	}
	
	public abstract void work();
}
