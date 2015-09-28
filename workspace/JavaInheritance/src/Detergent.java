class Cleanser{
	public String s = "Cleanser";
	void append(String i){ s += i;}
	void dilute(){append(" dilute() "); }
	void apply(){append(" apply() ");}
	void scrub(){append(" scrub() ");}
	
	@Override
	public String toString() {
		return s;
	}
	public static void main(String[] args) {
		Cleanser c = new Cleanser();
		c.dilute(); c.apply(); c.scrub();
		System.out.println(c);
	}
}
public class Detergent extends Cleanser {
	@Override
	void scrub() {
		append(" Detergent scrub() ");
		super.scrub();
	}
	void foam(){
		append(" foam() ");
	}
	public static void main(String[] args) {
		Detergent d = new Detergent();
		d.dilute();
		d.apply();
		d.scrub();
		d.foam();
		System.out.println(d);
		System.out.println("Check parent class");
		Cleanser.main(args);
	}
	
}
