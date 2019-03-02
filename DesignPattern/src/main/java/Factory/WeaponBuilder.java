package Factory;

import java.util.ArrayList;

public class WeaponBuilder {

	
	public static ArrayList<Weapon> produceMultiWeapon(int num){
		ArrayList<Weapon> weaponList = new ArrayList<Weapon>(num);
		for(int i =0; i < num; i++){
			weaponList.add(new Pistol("Desert Eagle", 100));
		}
		return weaponList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Weapon> weaponList = produceMultiWeapon(3);
		for(int i = 0; i < weaponList.size(); i++ ){
			weaponList.get(i).fire();
		}
	}

}
