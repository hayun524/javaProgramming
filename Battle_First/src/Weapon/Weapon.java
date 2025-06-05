package Weapon;

public class Weapon {
    public String 이름;
    public int 내구도;
    public int power;

    //getter, setter 설정 
    
    public void set이름(String 이름) {
		this.이름 = 이름;
	}

	public void set내구도(int 내구도) {
		this.내구도 = 내구도;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
    public String getName(){
        return this.이름;
    }

    public int getPower(){
        return this.power;
    }
    
    public int get내구도(){
        return this.내구도;
    }
    
    //생성자
    
    public Weapon(String 이름, int 내구도, int power) {
		super();
		this.이름 = 이름;
		this.내구도 = 내구도;
		this.power = power;
	}

    public void 무기교체(Weapon weapon){
        if (weapon.get내구도() == 0) 
        	System.out.printf("%s이/가 부러졌습니다! 이제 사용할 수 없어요!",weapon.getName());
   
    }

	
 
}
