package player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import weapon.Weapon;

public class Player {
    private String name;
    private int hp;
    private int power;
    private String 전용무기;
    private Weapon weapon;
    private String ImgFile1, ImgFile2;

    
    public Player(String name, int hp, int power, String 전용무기, String ImgFile1, String ImgFile2) {
        super();
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.전용무기 = 전용무기;
        
        this.ImgFile1 = ImgFile1;
        this.ImgFile2 = ImgFile2;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String get전용무기() {
		return 전용무기;
	}

	public void set전용무기(String 전용무기) {
		this.전용무기 = 전용무기;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Weapon chooseWeapon (ArrayList<Weapon> weaponPool) {
		// 스티브가 무기 선택
		
        Scanner scanner = new Scanner(System.in);
        List<Weapon> usableWeapons = new ArrayList<>();
       
        System.out.println(this.name + "가 사용할 무기를 선택하세요:");
        
        for (Weapon w : weaponPool) {
            if (w.get내구도() > 0) {
                usableWeapons.add(w);
            }
        }
        
        for (int i = 0; i < usableWeapons.size(); i++) {
            Weapon w = usableWeapons.get(i);
            System.out.printf("%d %s\n",(i+1),w.getName());
        }

        int choice = 0;
        while (choice < 1 || choice > usableWeapons.size()) {
            System.out.print("번호를 입력하세요 (1 ~ " + usableWeapons.size() + "): ");
            choice = Integer.parseInt(scanner.nextLine());
        }
        
        Weapon selected = usableWeapons.get(choice - 1);
        System.out.println(this.name + "가 " + selected.getName() + "을(를) 선택했습니다!");
        
        if (selected.getName().equals("검"))
        	System.out.println("전용무기 \'검\'선택!");
        
        return selected; //고른 무기 반환
        }
	
	//동작 메소드
	
	public void attack(Player attacker, Player target, Weapon weapon) {

	    System.out.println("---------- 공격 시작! ----------");
	    System.out.printf("%s가 %s을/를 공격합니다! ", attacker.name, target.name);

	    if (weapon.get내구도() == 0) {
	        System.out.printf("%s이/가 부러졌습니다! 이제 사용할 수 없어요!\n", weapon.getName());
	        weapon.set내구도(0);
	        return;
	    }

	    System.out.println("사용한 무기: " + weapon.getName());
	    System.out.printf("현재 %s의 내구도: %d\n", weapon.getName(), weapon.get내구도());

	    int damage = 0;

	    if (weapon.getName().equals(this.전용무기)) {
	        System.out.println("*전용무기 효과로 딜량 2배!!*");
	        damage = this.power * 2;
	    } else {
	        System.out.println("이건 쓸 줄 몰라요! 무작정 때리기!");
	        damage = this.power + weapon.power;
	    }

	    weapon.내구도 -= 1;

	    // 천사카드 효과 체크 
	    if (target instanceof Steve) {
	        Steve steve = (Steve) target;
	        if (steve.isAngelCardActive()) {
	            System.out.println("천사카드 효과로 피해를 무시합니다!");
	            steve.setAngelCardActive(false); // 효과 1회 후 비활성화
	            damage = 0;
	        }
	    }

	    target.hp -= damage;

	    System.out.println(attacker.name + "의 남은 HP: " + attacker.hp);
	    System.out.println(target.name + "의 남은 HP: " + target.hp);
	}

    public void showStatus(){
    	
    	
    	
    }

   

    
 
}
