package weapon;
import functions.Attackable;

public class Sword extends Weapon {

	@Override
	public void attackMotion() {
		// TODO Auto-generated method stub
		System.out.println("칼 휘두르기");
	}
	
	public Sword(String 이름, int 내구도, int power) {
		super(이름, 내구도, power);
	}

}
