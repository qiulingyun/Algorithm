package Factory;

public class SkodaWeaponFactory implements WeaponFactory {

	public Weapon produce() {
		// TODO Auto-generated method stub
		return new MiniGun();
	}
	
	public Weapon producePistol(){
	
		return new Pistol("CZ-100", 60);
	}

	public Weapon produceMiniGun(){
		return new MiniGun("ZB-26", 1500);
	}
	
}
