package innerclasses;

public class DotNew {
	public class Inner{}
	public static void main(String[] args) {
		DotNew dn = new DotNew();
		DotNew.Inner in = dn.new Inner();
	}
}