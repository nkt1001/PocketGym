package innerclasses;

public class Parcel17b {
	public Destination dest(final String dest, final float price){
		return new Destination() {
			private int coast;
			{
				coast = Math.round(price);
				if(coast>100)
					System.out.println("превышение бюджета");
			}
			private String label = dest;
			@Override
			public String readLabel() {
				// TODO Auto-generated method stub
				return label;
			}
		};
	}
	public static void main(String[] args) {
		Parcel17b p = new Parcel17b();
		p.dest("Miami", 101.1f);
	}
}
