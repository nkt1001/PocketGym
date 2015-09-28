class Characteristic{
	private String s;
	public Characteristic(String s) {
		// TODO Auto-generated constructor stub
		this.s=s;
		System.out.println("Создаем Characteristic " + s);
	}
	void dispose(){
		System.out.println("Завершаем Characteristic " + s);
	}
}
class Description{
	private String s;
	public Description(String s) {
		// TODO Auto-generated constructor stub
		System.out.println("Создаем Description " + s);
		this.s = s;
	}
	void dispose(){
		System.out.println("Завершаем Description " + s);
	}
}
class LivingCreature{
	Characteristic c = new Characteristic("живое существо");
	Description d = new Description("Обычное живое существо");
	public LivingCreature() {
		
		System.out.println("Living Creature()");
	}
	void dispose(){
		System.out.println("Завершаем Living Creature()");
		d.dispose();
		c.dispose();
	}
}
class Animal extends LivingCreature{
	Characteristic c = new Characteristic("Имеет сердце");
	Description d = new Description("Животное, не растение");
	public Animal() {
		
		System.out.println("Animal()");
	}
	protected void dispose(){
		System.out.println("Завершаем Animal()");
		d.dispose();
		c.dispose();
		super.dispose();
	}
}
class Amphibian extends Animal{
	Characteristic c = new Characteristic("может жить в воде");
	Description d = new Description("живет в воде и на земле");
	public Amphibian() {
		
		System.out.println("Amphibian()");
	}
	protected void dispose(){
		System.out.println("Завершаем Amphibian()");
		d.dispose();
		c.dispose();
		super.dispose();
	}
}
public class Frog extends Amphibian {
	Characteristic c = new Characteristic("квакает");
	Description d = new Description("ест жуков");
	public Frog() {
		System.out.println("Frog()");
	}
	protected void dispose(){
		System.out.println("Завершаем Frog()");
		d.dispose();
		c.dispose();
		super.dispose();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frog f = new Frog();
		System.out.println("Hasta la vista le frog");
		f.dispose();
	}

}
