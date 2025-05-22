package player;

import java.util.ArrayList;

import Weapon.Weapon;

public class Player {
    public String 이름;
    public int HP;
    public int power;
    public String 전용무기;
    public Weapon weapon; 
    
    
    //getter, setter
    public int getHP(){
    	return this.HP;
    }

    public int getpower(){
       	return this.power;
    }

    public Weapon getWeapon(){
    	return this.weapon;
    }
    
    public void setWeapon(Weapon weapon) {
	    this.weapon = weapon;
	}
    
    //생성자
    public Player(String 이름, int HP, int power, String 전용무기) {
        super();
        this.이름 = 이름;
        this.HP = HP;
        this.power = power;
        this.전용무기 = 전용무기;
    }
    
    //구현 메소드
	
	public void attack(Player target, Weapon weapon){ 
		
		System.out.println(this.이름 + "이/가 " + target.이름 + "를 공격합니다!");
		weapon.무기교체(weapon);
		
		System.out.println("사용한 무기: " + weapon.getName());  // 무기 이름 출력
		System.out.printf("현재 %s의 내구도: %d\n", weapon.getName(),weapon.내구도);//내구도 출력
		
		
		if (weapon.getName().equals(this.전용무기)) {
			System.out.println("*전용무기 효과로 딜량 2배!!*");
			target.HP -= (this.power)*2;
			weapon.내구도 -= 1;
		}
		else {
			System.out.println("이건 쓸 줄 몰라요! 무작정 때리기!");
			target.HP -= (this.power + weapon.power);
			weapon.내구도 -= 1;
		}
		
		System.out.println(target.이름 + "의 남은 HP: " + target.HP);
	}

	

}
