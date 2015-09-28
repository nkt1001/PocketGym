class Cheese{
	public Cheese() {
		// TODO Auto-generated constructor stub
		System.out.println("Cheese");
	}
}
class Bread{
	public Bread() {
		// TODO Auto-generated constructor stub
		System.out.println("Bread");
	}
}
class Meal{
	public Meal() {
		// TODO Auto-generated constructor stub
		System.out.println("Meal");
	}
}
class Lettuce{
	public Lettuce() {
	// TODO Auto-generated constructor stub
		System.out.println("Lettuce");
	}
}
class PortableMeal extends Meal{
	public PortableMeal() {
		// TODO Auto-generated constructor stub
		System.out.println("Portable Meal");
	}
}
public class Sandwich extends PortableMeal {
	Bread b = new Bread();
	Cheese c = new Cheese();
	Lettuce l = new Lettuce();
	
	public Sandwich() {
		// TODO Auto-generated constructor stub
		System.out.println("Sandwich");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sandwich();
	}

}
