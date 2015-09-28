package music;
public class Wind extends Instrument {
	void play(Note n){
		System.out.println("Wind.play() " + n);
	}
	void adjust(){
		System.out.println("Adjusting wind");
	}
	String what(){
		return "Wind";
	}
}