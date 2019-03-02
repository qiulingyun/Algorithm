package QLY.TestMaven;

public class Guy {
	private Weapon weapon;

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Guy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guy(Weapon weapon) {
		super();
		this.weapon = weapon;
	}
	
	public void useWeapon(){
		weapon.fire();
	}
}
