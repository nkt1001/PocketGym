class Wheel{
	void inflate(){}
}
class Window{
	void rollup(){}
	void rolldown(){}
}
class Engine{
	void start(){}
	void stop(){}
	void revese(){}
}
class Door{
	Window w = new Window();
	void open(){}
	void close(){}
}
public class Car {
	Wheel[] w = new Wheel[4];
	Door 
			left = new Door(),
			right = new Door();
	Engine e = new Engine();
	public Car() {
		for(int i = 0; i < w.length; i++)
			w[i] = new Wheel();
	}
	public static void main(String[] args) {
		Car car = new Car();
		car.e.start();
		car.left.w.rolldown();
		car.w[0].inflate();
		
	}
}
