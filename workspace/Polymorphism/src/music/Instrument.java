package music;

public class Instrument {
	void play(Note n){
		System.out.println("Intrument.play() " + n);
	}
	void adjust(Instrument i){
		System.out.println("Adjusting instrument");
	}
	String what(){
		return "Instrument";
	}
}