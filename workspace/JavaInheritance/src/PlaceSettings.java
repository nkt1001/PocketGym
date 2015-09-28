class Plate{
	public Plate(int i) {
		// TODO Auto-generated constructor stub
		System.out.println("конструктор Plate");
	}
}
class DinnerPlate extends Plate{
	public DinnerPlate(int i) {
		super(i);
		System.out.println("конструктор DinnerPlate");
		// TODO Auto-generated constructor stub
	}
}
class Utensil{
	public Utensil(int i) {
		// TODO Auto-generated constructor stub
		System.out.println("конструктор Utensil");
	}
}
class Spoon extends Utensil{
	public Spoon(int i) {
		super(i);
		System.out.println("конструктор Spoon");
		// TODO Auto-generated constructor stub
	}
}
class Fork extends Utensil{
	public Fork(int i) {
		super(i);
		System.out.println("конструктор Fork");
		}
}
class Knife extends Utensil{
	public Knife(int i) {
		super(i);
		System.out.println("конструктор Knife");
	}
}
class Custom{
	public Custom(int i) {
		System.out.println("конструктор Custom");
	}
}
public class PlaceSettings extends Custom {
	DinnerPlate plates;
	Fork forks;
	Spoon spoons;
	Knife knifes;
	public PlaceSettings(int i) {
		super(i+1);
		forks = new Fork(i+2);
		spoons = new Spoon(i+3);
		knifes = new Knife(i+4);
		plates = new DinnerPlate(i+5);
		System.out.println("конструктор PlaceSettings");
	}
	public static void main(String[] args) {
		new PlaceSettings(9);
	}
}
