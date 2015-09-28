package innerclasses;

public class Parcel3 {
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
	
	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		Parcel3.Contents c = p.new Contents();
		Parcel3.Destination d = p.new Destination("Brazil");
		System.out.println(d.readLabel());
	}
}
