class Glyph{
	void draw(){
		System.out.println("Glyph.draw()");
	}
	public Glyph() {
		System.out.println("До вызова draw()");
		draw();
		System.out.println("После вызова draw()");
	}
}
class RoundGlyph extends Glyph{
	private int r = 1;
	void draw(){
		System.out.println("RoundGlyph.draw() radius = " + r);
	}
	public RoundGlyph(int radius) {
		r = radius;
		System.out.println("RoundGlyph(), radius = " + r);
		
	}
	
}
public class PolyContructions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RoundGlyph(5);
	}

}
