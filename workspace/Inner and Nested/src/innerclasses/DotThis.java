package innerclasses;

public class DotThis {
	private void f(){System.out.println("DotThis.f()");}
	public class Inner{
		public DotThis outer(){return DotThis.this;}
	}
	public Inner inner(){return new Inner();}
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		Inner in = dt.inner();
		in.outer().f();
	}
}