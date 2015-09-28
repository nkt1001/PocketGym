package geometry;

import java.util.Random;

public class RandomShapeGenerator {
	Random rand = new Random(77);
	public Shape next(){
		switch(rand.nextInt(3)){
		default:
		case 0: return new Circle();
		case 1: return new Triangle();
		case 2: return new Rectangle();
		}
	}
}
