package nestedclasses;
import innerclasses.Contents;
import innerclasses.Destination;;
public class Parcel10 {
	private static class PContents implements Contents{
		private int i = 11;
		@Override
		public int value() {
			// TODO Auto-generated method stub
			return i;
		}
	}
	protected static class PDestination implements Destination{
		private String label;
		private PDestination(String whereTp) {
			label = whereTp;
		}
		@Override
		public String readLabel() {
			// TODO Auto-generated method stub
			return label;
		}
		public static void f(){}
		static int x = 10;
		static class AnotherLevel{
			static int x = 11;
			public static void f(){}
		}
	}
	public static Destination dest(String s){
		return new PDestination(s);
	}
	public static Contents cont(){
		return new PContents();
	}
	public static void main(String[] args) {
		Destination d = dest("ss");
		Contents c = cont();
	}
}
