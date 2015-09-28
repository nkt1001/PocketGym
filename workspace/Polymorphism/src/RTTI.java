class Useful{
	void f(){}
	void g(){}
}
class MoreUseful extends Useful{
	void f(){}
	void g(){}
	void u(){}
	void v(){}
	void w(){}
}
public class RTTI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Useful[] x = {new Useful(), new MoreUseful()};
		//x[1].u();
		((MoreUseful)x[0]).u();
		((MoreUseful)x[1]).u();
	}

}
