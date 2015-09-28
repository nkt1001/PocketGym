package innerclasses;

public class Parcel1 {
	class Contents{
		private int i =11;
		public int value(){return i;}
	}
	class Destination{
		private String label;
		public Destination(String whereTo){
			label = whereTo;
		}
		String readLabel(){return label;} 
	}
	//использование внутренних классов имеет много общего с использованием 
	//других классов в пределах parcel1
	public void ship(String dest){
		Contents c = new Contents();
		Destination d = new Destination(dest);
		System.out.println(d.readLabel());
	}
	public static void main(String[] args) {
		Parcel1 p = new Parcel1();
		p.ship("Brazil");
	}
}
