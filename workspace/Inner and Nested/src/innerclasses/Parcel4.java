package innerclasses;
public interface Contents{
	public int value();
}
public interface Destination{
	String readLabel(); 
}
public class Parcel4 {
	private class PContents implements Contents{
		private int i =11;
		public int value(){return i;}
	}
	protected class PDestination implements Destination{
		private String label;
		public PDestination(String whereTo){
			label = whereTo;
		}
		public String readLabel(){return label;} 
	}
	public Contents content(){return new PContents();}
	public Destination destination(String whereTo)
			{return new PDestination(whereTo);}

	public static void main(String[] args) {
		Parcel4 p =new Parcel4();
		Contents c = p.content();
		Destination d = p.destination("Europe");
		//!Parcel4.PContents s = new Parcel4.Pcontents();
	}
}
