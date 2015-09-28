package innerclasses;

public class Parcel5 {
	public Destination dest(String label){

		class PDestination implements Destination{
		
		private String label;
		public PDestination(String whereTo){
			label = whereTo;
		}
		@Override
		public String readLabel() {
			// TODO Auto-generated method stub
			return label;
		}
		}
		return new PDestination(label);
	}
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		p.dest("Somewhere");
	}
}
