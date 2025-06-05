package player;
public class Steve extends Player {

	private boolean angelCardActive = false;  // 천사카드 상태 저장

	public boolean isAngelCardActive() {
	    return angelCardActive;
	}

	public void setAngelCardActive(boolean angelCardActive) {
	    this.angelCardActive = angelCardActive;
	}

	 public void 천사카드사용(){
	        this.angelCardActive = true;
	        System.out.println("천사카드 발동! 다음 피해 1회 무시됩니다.");
	    }
	    
	public Steve (String  name, int HP, int power, String 전용무기, String ImgFile1, String ImgFile2) {
		super(name, HP, power, 전용무기, ImgFile1, ImgFile2);
		// TODO Auto-generated constructor stub
	}
	
    public void 침대에서숙면(){
    	
    	this.setHp(getHp()+100);
    	System.out.println("HP 100 회복!");
    	System.out.println("스티브의 현재 HP: "+this.getHp());
    	
    }

   

}
