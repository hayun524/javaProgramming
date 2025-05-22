package Weapon;

import Function.Shootable;
import player.Player;

public class Bow extends Weapon implements Shootable {

	@Override
	public void shoot(Player target) {
		// TODO Auto-generated method stub
		
	}

	public Bow(String 이름, int 내구도, int power) {
		super(이름, 내구도, power);
	}
	

}
