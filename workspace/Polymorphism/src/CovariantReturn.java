class Grain{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Grain";
	}
}
class Wheat extends Grain{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Wheat";
	}
}
class Mill{
	Grain process(){return new Grain();}
}
class WheatMill extends Mill{
	Wheat process(){return new Wheat();}
}
public class CovariantReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mill m = new Mill();
		Grain g = m.process();
		System.out.println(g);
		m = new WheatMill();
		g = m.process();
		System.out.println(g);

	}

}
