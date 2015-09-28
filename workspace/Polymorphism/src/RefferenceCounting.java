class Shared{
	private int refCounter = 0;
	private static long counter = 0;
	private final long id = counter++;
	Shared(){
		System.out.println("Creating " + this);
	}
	public void addRef(){refCounter++;}
	protected void dispose(){
		if(--refCounter == 0)
			System.out.println("Disposing " + this);
	}
	@Override
	public String toString() {
		return "Shared " + id;
	}
}
class Composing{
	private Shared sh;
	private static long counter =0;
	private long id = counter++;
	public Composing(Shared shared) {
		System.out.println("Creating " + this);
		sh = shared;
		sh.addRef();
	}
	void dispose(){
		System.out.println("Disposing " + this);
		sh.dispose();
	}
	@Override
	public String toString() {
		return "Composing " + id;
	}
}
public class RefferenceCounting {

	public static void main(String[] args) {
		Shared s = new Shared();
		Composing[] c = {new Composing(s),new Composing(s),new Composing(s),
				new Composing(s),new Composing(s),new Composing(s),
				new Composing(s)};
		for(Composing comp : c)
			comp.dispose();

	}

}
