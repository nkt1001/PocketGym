package testtask;

public class Task4 {
	public static void main(String[] args) {
		Dot[] dots = {new Dot(6, 7), new Dot(1, 4), new Dot(), 
				new Dot(1, -3), new Dot(3, 0)};
		
		Task4 t = new Task4();
		CurvedLine myLine = CurvedLine.createCurvedLine(dots);
		
		System.out.println(myLine);
	}
}
//class Dot has information about dot coordinates x and y, getters and setters
class Dot{
	private int x;
	private int y;
	//default constructor
	public Dot(){
		x=0;
		y=0;
	}
	public Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	//toString for system.out.println
	public String toString() {
		return x+";"+y; 
	}
}
class CurvedLine{
	static Dot[] dots;
	//gets all dots and define how to combine dots without intersections
	static CurvedLine createCurvedLine(Dot[] randomDots){
		dots = randomDots.clone();
		int size = randomDots.length;
		//create line by dint of dots array		
		for(int i = 0; i < size; i++){
			Dot d = dots[i];
			int pos = i;
			//check coordinate X of dots and define which one that located leftmost
			//than put it to the top
			//after that cycle will keep looking for dots to the right
			for(int j = i; j < size; j++){
				if(d.getX() > dots[j].getX()){
					d = dots[j];
					pos = j;
				}
				//if two or more dots located at the same line
				//the cycle will pick one that below
				else if(d.getX() == dots[j].getX()){
					if(d.getY() > dots[j].getY()){
						d = dots[j];
						pos = j;
					}
				}
				if(!d.equals(dots[i])){
					dots[pos] = dots[i];
					dots[i] = d;
				}
			}
		}
		
		return new CurvedLine();
	}
	//toString for system.out.println
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Dot d : dots){
			sb.append("(");
			sb.append(d.toString());
			sb.append(") ");
		}
		return sb.toString();
	}
}
