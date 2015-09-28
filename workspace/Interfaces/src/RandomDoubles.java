import java.util.Random;

public class RandomDoubles {
private static Random r = new Random();
public double next(){return r.nextDouble();}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomDoubles s = new RandomDoubles();
		for(int i = 0; i < 7; i++){
			System.out.println(s.next() + " ");
		}
	}

}