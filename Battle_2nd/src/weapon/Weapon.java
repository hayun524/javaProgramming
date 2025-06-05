package weapon;

import weapon.Weapon;

public class Weapon implements Attackable{
    private String name;
    public int power;
    public int 내구도;

    
    //getter, setter
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int get내구도() {
		return 내구도;
	}

	public void set내구도(int 내구도) {
		this.내구도 = 내구도;
	}
    
    
    //생성자
    
    public Weapon(String name, int 내구도, int power) {
		super();
		this.name = name;
		this.내구도 = 내구도;
		this.power = power;
	}

	@Override
	public void attackMotion() {
		// TODO Auto-generated method stub
		
	}

}
