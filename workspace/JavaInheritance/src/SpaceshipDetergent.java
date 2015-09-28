
public class SpaceshipDetergent {
private String name;
private SpaceshipControls controls = new SpaceshipControls();
public SpaceshipDetergent(String name) {
	this.name = name;
}
void up(int velocity){controls.up(velocity);}
void down(int velocity){controls.down(velocity);}
void right(int velocity){controls.right(velocity);}
void left(int velocity){controls.left(velocity);}
void forward(int velocity){controls.forward(velocity);}
void back(int velocity){controls.back(velocity);}
void turboboost(){controls.turboboost();}

public static void main(String[] args) {
	SpaceshipDetergent protector = 
			new SpaceshipDetergent("NSEA Protector");
	protector.left(20);
}
}
