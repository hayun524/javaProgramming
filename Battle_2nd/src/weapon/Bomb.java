package weapon;
import functions.Attackable;
import player.Player;

public class Bomb extends Weapon {

	@Override
	public void attackMotion() {
		// TODO Auto-generated method stub
		System.out.println("펑펑!");
	}
	
	public Bomb(String 이름, int 내구도, int power) {
		super(이름, 내구도, power);
	}

}
