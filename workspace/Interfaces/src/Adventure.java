interface CanFly{
	void fly();
}
interface CanFight{
	void fight();
}
interface CanSwimm{
	void swimm();
}
class ActionCharacter{
	public void fight(){}
}
class Hero extends ActionCharacter implements CanFight, CanSwimm, CanFly{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swimm() {
		// TODO Auto-generated method stub
		
	}
	
}
public class Adventure {
	
	static void t(CanFight h){h.fight();}
	static void u(CanSwimm h){h.swimm();}
	static void f(CanFly h){h.fly();}
	static void w(ActionCharacter h){h.fight();}
	public static void main(String[] args) {
		Hero hero = new Hero();
		t(hero); //используем в качастве canfight
		u(hero); //используем в качастве canswimm
		f(hero); //используем в качастве canfly
		w(hero); //используем в качастве actioncharacter
	}

}
