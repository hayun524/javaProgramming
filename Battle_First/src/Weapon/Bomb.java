package Weapon;

import Function.Tossable;
import player.Player;

public class Bomb extends Weapon implements Tossable {

	@Override
	public void toss(Player target) {
		// TODO Auto-generated method stub
		
	}
	
	public Bomb(String 이름, int 내구도, int power) {
		super(이름, 내구도, power);
	}

}
