package Main;

import player.Player;
import player.Creeper;
import player.Skeleton;
import player.Steve;
import player.Zombie;
import Weapon.Bomb;
import Weapon.Bow;
import Weapon.Poison;
import Weapon.Sword;
import Weapon.Weapon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void consoleGame(Player p1, Player p2,Player p3, Player p4, Weapon w1, Weapon w2, Weapon w3,Weapon w4) {
		
		
		//ArrayList, Collections.shuffle() 넣어서 무기 랜덤 배정 기능 제작
		
    	while (true) { //턴 진입
    		System.out.println("=======START=======");
    		
    		//무기, 플레이어 리스트 생성
	    	ArrayList<Weapon> WeaponPool =
	    	          new ArrayList<>(Arrays.asList(w1,w2,w3,w4));
	        ArrayList<Player> players = 
	        		new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
	        
    		boolean isAnyDead = false;
    		for (Player p : players) {
    		    if (p.getHP() <= 0) {
    		        System.out.printf("%s died!\n THE END", p.이름);
    		        isAnyDead = true;
    		    }  //1명 죽을때까지 반복
    		}
    		if (isAnyDead == true)
    			break;

	    	Collections.shuffle(WeaponPool);
    		
	    	// 각 플레이어에게 랜덤하게 무기 하나씩 할당
	        for (int i = 0; i < players.size(); i++) {
	            players.get(i).setWeapon(WeaponPool.get(i));
	            //i번째 플레이어에게 i번째 무기를 할당
	        }
	        
	        //attacker, target 정하기(random.Math)
	        int attackerIdx = (int)(Math.random() * players.size());
	        int targetIdx;
	        do { //attacker랑 안 겹치게
	            targetIdx = (int)(Math.random() * players.size());
	        } while (targetIdx == attackerIdx);
	        
	        Player attacker = players.get(attackerIdx);
	        Player target = players.get(targetIdx);


    		//공격턴진입
	        attacker.attack(target, attacker.getWeapon());
    		}
    	}
	
	public static void main(String[] args) {
		//main에서 캐릭터, 무기 생성하고 ConsoleGame에다 전달하는 식으로 수정
		
		//캐릭터 생성 (이름, HP, power, 전용무기)
		Steve p1 = new Steve("스티브",150,15,"검");
		Skeleton p2 = new Skeleton("스켈레톤",130,20,"활");
		Creeper p3 = new Creeper("크리퍼",100,50,"폭탄");
		Zombie p4 = new Zombie("좀비",180,10,"독");
				
				//무기 생성(이름, 내구도, power)
		Sword w1 = new Sword("검", 3, 3);
		Bow w2 = new Bow("활", 3, 2);
		Bomb w3 = new Bomb("폭탄", 3, 1);
		Poison w4 = new Poison("독", 3, 5);
				
		consoleGame(p1, p2, p3, p4, w1, w2, w3, w4);
		
		
	}
}
