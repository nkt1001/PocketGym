package innerclasses;
interface Service{
	void method1();
	void method2();
}
interface ServiceFactory{
	Service getService();
}
class Implementation1 implements Service{
	private Implementation1(){}
	@Override
	public void method1() {
		System.out.println("Implementation1 method1()");
	}

	@Override
	public void method2() {
		System.out.println("Implementation1 method1()");		
	}
	public static ServiceFactory factory = new ServiceFactory() {
			
			@Override
			public Service getService() {
				// TODO Auto-generated method stub
				return new Implementation1();
			}
		};
	}
class Implementation2 implements Service{
	private Implementation2(){}
	@Override
	public void method1() {
		System.out.println("Implementation2 method2()");
	}

	@Override
	public void method2() {
		System.out.println("Implementation2 method2()");		
	}
	public static ServiceFactory factory = new ServiceFactory() {
		
		@Override
		public Service getService() {
			// TODO Auto-generated method stub
			return new Implementation2();
		}
	};
}

public class Factories {
	public static void serviceCustomer(ServiceFactory fac){
		Service s = fac.getService();
		s.method1();
		s.method2();
	}
	public static void main(String[] args) {
		serviceCustomer(Implementation1.factory);
		serviceCustomer(Implementation2.factory);
	}
}