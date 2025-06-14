package weapon;
import functions.Attackable;

public class Poison extends Weapon implements Attackable {

	@Override
	public void attackMotion() {
		// TODO Auto-generated method stub
		System.out.println("중독!");
	}
	
	public Poison(String 이름, int 내구도, int power) {
		super(이름, 내구도, power);
	}


}
