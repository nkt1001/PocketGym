class A{
	interface B{void f();}
	public class BImp implements B{
		public void f() {}		
	}
	private class BImp2 implements B{
		public void f() {}		
	}
	public interface C{void f();}
	public class CImp implements C{
		public void f() {}		
	}
	private class CImp2 implements C{
		public void f() {}		
	}
	private interface D{void f();}
	public class DImp implements D{
		public void f() {}		
	}
	public class DImp2 implements D{
		public void f() {}		
	}
	public D getD(){return new DImp2();}
	private D dRef;
	public void recieveD(D d){
		dRef = d;
		dRef.f();
	}
}

interface E{
	interface G{
		public void f();
	}
	interface H{
		public void f();
	}
	void g();
	//private interface G{}
}


public class NestingInterfaces {
	public class BImp implements A.B{
		public void f(){}
	}
	class CImp implements A.C{
		public void f(){}
	}
	//private interface не может быть реализован
	//нигде, кроме как внутри класса где был определен
	//class DImp implements A.D
	public class EImp implements E{
		public void g() {}
	}
	
	class EGImp implements E.G{
		public void f(){}
	}
	
	class EImp2 implements E{
		public void g(){}
		class EG implements E.G{
			public void f(){}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		
		//нет доступа к A.D
		//A.D ad = a.getD();
		//Не возвращает ничего кроме А.Д
		//A.DImp2 adim2 = a.getD();
		//Член интерфейса недоступен
		//a.getD().f();
		//Только другой класс А может использовать getD()
		A a2 = new A();
		a2.recieveD(a.getD());
	}

}