package Factory;

public class MiniGun implements Weapon {

	private String name;
	private int range;
	
	
	public MiniGun() {
		super();
		this.range = 80;
	}


	public MiniGun(String name, int range) {
		super();
		this.name = name;
		this.range = range;
	}


	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void fire() {
		// TODO Auto-generated method stub
		System.out.println(name + " fire:" + "Da Da Da !");
	}

}
