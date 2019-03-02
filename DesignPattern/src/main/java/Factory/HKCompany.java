package Factory;

public class HKCompany implements WeaponFactory {

	public Weapon produce() {
		// TODO Auto-generated method stub
		return new Pistol("USP", 50);
	}
	
	public static Weapon producePistol(){
		return new Pistol("USP", 50);
	}
	
	public static Weapon produceMiniGun(){
		return new MiniGun("MG43", 1500);
	}

}
