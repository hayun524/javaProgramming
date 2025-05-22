package Weapon;

import Function.Slashable;
import player.Player;

public class Sword extends Weapon implements Slashable {

	@Override
	public void slash(Player target) {
		// TODO Auto-generated method stub
		
	}
	
	public Sword(String 이름, int 내구도, int power) {
		super(이름, 내구도, power);
	}


}
