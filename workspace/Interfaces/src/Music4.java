abstract class Instrument {
	abstract void play(Note n);
	abstract void adjust();
	String what(){
		return "Instrument";
	}
}

class Stringer extends Instrument{
	void play(Note n){
		System.out.println("Stringer.play() " + n);
	}
	void adjust(){
		System.out.println("Adjusting stringer");
	}
	String what(){
		return "Stringer";
	}
	
}
class Wind extends Instrument {
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
class Percussion extends Instrument{
	void play(Note n){
		System.out.println("Percussion.play() " + n);
	}
	void adjust(){
		System.out.println("Adjusting percussion");
	}
	String what(){
		return "Percussion";
	}
}
class Brass extends Wind{
	void play(Note n){
		System.out.println("Brass.play() " + n);
	}

	String what(){
		return "Brass";
	}
}
class WoodWind extends Wind{
	void play(Note n){
		System.out.println("WoodWind.play() " + n);
	}
	
	String what(){
		return "WoodWind";
	}
}
	

public class Music4 {
	//работа метода не зависит от фактического типа объекта
	//поэтому типы, добавленные в систему будут работать правильно

	public static void tune(Instrument i){
		///...
		i.play(Note.MIDDLE_C);
	}
	public static void tuneAll(Instrument[] args){
		for(Instrument i : args)
			tune(i);
	}
	
	public static void main(String[] args) {
		//восходящее преобразование при добавлении в массив
		Instrument[] orchestra = {new Brass(),
				new Percussion(), new WoodWind(),
				new Wind(), new Stringer()};
		
		tuneAll(orchestra);
	}

}