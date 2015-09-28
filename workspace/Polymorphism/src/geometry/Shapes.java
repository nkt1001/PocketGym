package geometry;

public class Shapes {

	public static void main(String[] args) {
		RandomShapeGenerator gen = new RandomShapeGenerator();
		Shape[] shapes = new Shape[33];
		for(int i = 0; i < shapes.length; i++){
			shapes[i] = gen.next();
			shapes[i].draw();
		}
	}

}