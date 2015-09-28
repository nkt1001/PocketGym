class WaterSource{
	private String s;
	
	public WaterSource() {
		System.out.println("WaterSource()");
		s = "сконструировано";
	}
	
	public String toString(){
		return s;
	}
}

public class SprinklerSystem {
	private String valve1, valve2, valve3, valve4;
	private int i;
	private float f;
	WaterSource source = new WaterSource();
	
	@Override
	public String toString() {
		return 
				"valve 1 " + valve1 + " " + 
				"valve 2 " + valve2 + " " +
				"valve 3 " + valve3 + " " +
				"valve 4 " + valve4 + "\n" +
				"i = " + i + " f = " + f + 
				"\nsource = " + source;
	}
	
	public static void main(String[] args) {
		
		System.out.print(new SprinklerSystem());
	}
}
