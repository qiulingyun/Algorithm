package Factory;

public class Customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SkodaWeaponFactory factory = new SkodaWeaponFactory();
		Weapon weapon = factory.producePistol();
		weapon.fire();
		weapon = factory.produceMiniGun();
		weapon.fire();
		
		weapon = HKCompany.produceMiniGun();
		weapon.fire();
	}

}
