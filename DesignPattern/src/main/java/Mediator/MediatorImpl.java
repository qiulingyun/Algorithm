package Mediator;

public class MediatorImpl implements Mediator {

	private AbstractUser user1;
	private AbstractUser user2;
	
	
	public MediatorImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MediatorImpl(AbstractUser user1, AbstractUser user2) {
		super();
		this.user1 = user1;
		this.user2 = user2;
	}

	public AbstractUser getUser1() {
		return user1;
	}

	public void setUser1(AbstractUser user1) {
		this.user1 = user1;
	}

	public AbstractUser getUser2() {
		return user2;
	}

	public void setUser2(AbstractUser user2) {
		this.user2 = user2;
	}

	public void InitMediator() {
		user1 = new User1(this);
		user2 = new User2(this);

	}

	public void workAll() {
		if(user1 != null){
			user1.work();
		}
		if(user2 != null){
			user2.work();
		}
	}

}
