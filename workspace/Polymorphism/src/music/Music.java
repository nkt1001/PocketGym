package music;

public class Music {
	
	public static void tune(Instrument i){
		//....
		i.play(Note.C_SHARP);
	}
	public static void main(String[] args) {
		Wind flute = new Wind();
		tune(flute);
	}
}
