interface Monster{
	void menace();
}
interface DangerousMonster extends Monster{
	void destroy();
}
interface Lethal{
	void kill();
}
class DragonZilla implements DangerousMonster{

	@Override
	public void menace() {}

	@Override
	public void destroy() {}
	
}
interface Vampire extends Lethal, DangerousMonster{
	void drinkBlood();
}
class VeryBadVampire implements Vampire{

	@Override
	public void menace() {}

	@Override
	public void kill() {}

	@Override
	public void drinkBlood() {}

	@Override
	public void destroy() {}
	
}
public class HorrorShow {
	static void u(Monster m){m.menace();}
	static void v(DangerousMonster m){m.menace();
										m.destroy();}
	static void w(Lethal l){l.kill();}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		Vampire vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);
	}

}