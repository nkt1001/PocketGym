class Soap{
	private String s;
	Soap() {
		System.out.println("Soap()");
		s = "Constructed";			
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return s;
	}
}
public class Bath {
	private String s1,s2,
	s3 = "Happy", s4 = "Happy";
	private int i;
	private float toy;
	private Soap castille;
	
	public Bath() {
		System.out.println("in Bath constructor");
		s2 = "Cheerful";
		castille = new Soap();
		toy = 3.14f;
	}
	//инициализация экземпляра
	{
		i = 1;
	}
	@Override
	public String toString() {
		return
				"s1 " + s1 + "\n" +
				"s2 " + s2 + "\n" +
				"s3 " + s3 + "\n" +
				"s4 " + s4 + "\n" +
				"i = " + i + "\n" +
				"toy =  " + toy + "\n" +
				"castille " + castille;
			
	}
	public static void main(String[] args) {
		System.out.println(new Bath());

	}

}
