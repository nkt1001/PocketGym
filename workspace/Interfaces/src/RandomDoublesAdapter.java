import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class RandomDoublesAdapter extends RandomDoubles implements Readable {
	private static int counter;
	RandomDoubles rd = new RandomDoubles();
	public RandomDoublesAdapter(int c) {
		// TODO Auto-generated constructor stub
		counter = c;
	}
	@Override
	public int read(CharBuffer cb) throws IOException {
		// TODO Auto-generated method stub
		if (counter-- == 0)
		return -1;
		
		String s = rd.next() + " ";
		cb.append(s);
		return s.length();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(new RandomDoublesAdapter(7));
		while(sc.hasNextDouble())
			System.out.println(sc.nextDouble());
	}

}