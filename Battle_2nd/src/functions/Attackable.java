package functions;
public interface Attackable {
	public default void attackMotion() {
		
		System.out.println("공격모션 시전!");
		
	}
}
