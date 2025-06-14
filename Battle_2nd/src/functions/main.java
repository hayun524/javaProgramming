package functions;

import weapon.Bomb;
import weapon.Bow;
import weapon.Poison;
import weapon.Sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import weapon.Weapon;
import player.Creeper;
import player.Player;
import player.Skeleton;
import player.Steve;
import player.Zombie;

public class main {
	
	public static void ConsoleGame(Player p1,Player p2,Player p3,Player p4,
			Weapon w1, Weapon w2, Weapon w3, Weapon w4) {
		
				//무기, 몬스터 리스트 생성
				ArrayList<Weapon> WeaponPool =
		  	          new ArrayList<>(Arrays.asList(w1,w2,w3,w4));
				
				ArrayList<Player> Monsters = 
		      		new ArrayList<>(Arrays.asList(p2, p3, p4));
		     
				
				//몬스터에게 무기 배정
		        
		        while (true) { //공격 phase 진입
		        	
		        	if (p1.getHp() <= 0) {
		                System.out.println("스티브가 죽었습니다! 게임 오버!");
		                break;
		            }
		        	
		        	// 살아있는 몬스터 리스트 생성
		        	ArrayList<Player> aliveMonsters = new ArrayList<>();
		            for (Player m : Monsters) {
		                if (m.getHp() > 0) {
		                    aliveMonsters.add(m);
		                }
		            }

		            // 몬스터가 한 마리도 없으면 스티브 승리
		            if (aliveMonsters.isEmpty()) {
		                System.out.println("모든 몬스터를 처치했습니다! 승리!");
		                break;
		            }

		            Scanner scanner = new Scanner(System.in);
		            
		            System.out.println("=============FIGHT!=============");
		            System.out.println("공격하기(1) 능력사용하기(2)");
		            
		            
		            int a = scanner.nextInt();
		            
		            if (a == 1) //공격하기 
		            {

		            Weapon chosenWeapon = p1.chooseWeapon(WeaponPool);
		            p1.setWeapon(chosenWeapon);
				
					//스티브랑 만날 몬스터 지정(순서대로)

			        Player attacker = p1; //공격자는 항상 스티브
			        Player target = aliveMonsters.get(0);
			      
					//싸우기
			        p1.attack(p1, target, p1.getWeapon());

			        // 몬스터가 무작위 무기 장착하고 반격
			        if (target.getHp() > 0) {
			            Weapon randomWeapon = WeaponPool.get((int)(Math.random() * WeaponPool.size()));
			            target.setWeapon(randomWeapon);
			            target.attack(target, p1, target.getWeapon());
			        }
		          }
		            else { //고유능력사용
		            	System.out.println("침대에서숙면(1) 천사카드사용(2)");
		            	
		            	int b = scanner.nextInt();
		            	
		            	if (b==1)
		            		((Steve) p1).침대에서숙면();
		            	else
		            		((Steve) p1).천사카드사용();
		            }
		        }
	}
	
	public static void winGame(Player p1,Player p2,Player p3,Player p4,
			Weapon w1, Weapon w2, Weapon w3, Weapon w4) {
		
		 new UI_first(p1,p2,p3,p4,w1,w2,w3,w4).setVisible(true);
	}
	
	public static void main(String[] args) {
		
		//main에서 캐릭터, 무기 생성하고 ConsoleGame에다 전달하는 식으로 수정
		
		//캐릭터 생성 (이름, HP, power, 전용무기)
		Steve p1 = new Steve("스티브",250,10,"검", "스티브.png", "죽은스티브.png");//이미지 이름 넣기
		Zombie p2 = new Zombie("좀비",150,15,"독", "좀비.png", "죽은좀비.png");
		Skeleton p3 = new Skeleton("스켈레톤",100,10,"활", "스켈레톤.png", "죽은스켈레톤.png" );
		Creeper p4 = new Creeper("크리퍼",75,5,"폭탄", "크리퍼.png", "죽은크리퍼.png");
						
		//무기 생성(이름, 내구도, power)
		Sword w1 = new Sword("검", 10, 20);
		Bow w2 = new Bow("활", 10, 5);
		Bomb w3 = new Bomb("폭탄", 10, 15);
		Poison w4 = new Poison("독", 10, 30);
					
		//ConsoleGame(p1,p2,p3,p4,w1,w2,w3,w4);
		
		winGame(p1,p2,p3,p4,w1,w2,w3,w4);
	}

}
