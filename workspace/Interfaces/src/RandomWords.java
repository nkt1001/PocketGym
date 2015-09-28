import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {
	private static String alphabeth = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static char[] capital = alphabeth.toCharArray();
	private static char[] lower = alphabeth.toLowerCase().toCharArray();
	private static char[] vowels = "aeiou".toCharArray(); 
	private static Random rand = new Random();
	private int count;
	public RandomWords(int count) {
		this.count = count;
	}
	@Override
	public int read(CharBuffer cb) throws IOException {
		if(count-- == 0)
		return -1;
		cb.append(capital[rand.nextInt(capital.length)]);
		for(int i = 0; i < 4; i++){
			cb.append(vowels[rand.nextInt(vowels.length)]);
			cb.append(lower[rand.nextInt(lower.length)]);
		}
		cb.append(" ");
		return 5;//колво пирсоединенных символов
	}
	
	public static void main(String[] args) {
		RandomWords r = new RandomWords(150);
		Scanner scanner = new Scanner(r);
		while(scanner.hasNext()){
			System.out.println(scanner.next());
		}
		
	}

	

}
