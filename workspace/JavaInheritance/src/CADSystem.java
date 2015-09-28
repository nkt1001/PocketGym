class Shape{
	public Shape(int i) {
		System.out.println("Shape()");
	}
	void dispose(){System.out.println("Disposing Shape()");}
}
class Circle extends Shape{
	public Circle(int i) {
		super(i);
		System.out.println("Drawing circle");
	}
	@Override
	void dispose() {
		System.out.println("Disposing circle");
		super.dispose();
	}
}
class Triangle extends Shape{
	public Triangle(int i) {
		super(i);
		System.out.println("Drawing triangle");
	}
	@Override
	void dispose() {
		System.out.println("Disposing triangle");
		super.dispose();
	}
}
class Line extends Shape{
	private int start, end;
	public Line(int start, int end) {
		super(start);
		this.start = start;
		this.end = end;
		System.out.println("Drawing line " + 
		start+" , " + end);
	}
	@Override
	void dispose() {
		System.out.println("Disposing line " + 
		start+" , " + end);
		super.dispose();
	}
}

public class CADSystem extends Shape {
	Circle cir;
	Triangle tri;
	Line[] lines = new Line[3];
	
	public CADSystem(int i) {
		super(i+1);
		for(int j = 0; j < lines.length; j++){
			lines[j] = new Line(j, j*j);
		}
		cir = new Circle(1);
		tri = new Triangle(1);
		System.out.println("Combitaned constructor");
	}
	@Override
	void dispose() {
		// TODO Auto-generated method stub
		System.out.println("CAD disposing");
		//Disposing is carried out in reverse order
		tri.dispose();
		cir.dispose();
		for(Line l : lines)
			l.dispose();
		super.dispose();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CADSystem cad = new CADSystem(47);
		try{
			
		}
		finally{
			cad.dispose();
		}
	}

}
