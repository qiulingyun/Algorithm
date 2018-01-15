package Factory;

public class Pistol implements Weapon {

	private String name;
	private int range;
	public Pistol() {
		super();
		this.range = 50;
	}

	public Pistol(String name, int range) {
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
		System.out.println(name + " fire:" + "Ping!");
	}

}
