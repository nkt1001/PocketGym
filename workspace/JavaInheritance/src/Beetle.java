class Insect{
	private int i = 9;
	protected int k;
	public Insect() {
		System.out.println("i = " + i + "\nk = " + k);
		k = 77;
	}
	private static int x1 = printInit("Поле static Insect.x1 инициализировано");
	static int printInit(String s){
		System.out.println(s);
		return 3;
	}
}
public class Beetle extends Insect {
	private int z = printInit("Поле Beetle.z инициализировано");
	public Beetle() {
		System.out.println("z = " + z + "\nk = " + k);
	}
	private static int x2 = printInit("Поле static Beetle.x2 проинициализировано");
	
	public static void main(String[] args) {
		System.out.println("Конструктор Beetle");
		new Beetle();
	}

}
