package music5;


interface Instrument {
	void play(Note n);
	void adjust();
	//константа времени компиляции
	int VALUE = 5; // автоматически final and public
	
}

class Stringer implements Instrument{
	public void play(Note n){
		System.out.println("Stringer.play() " + n);
	}
	public void adjust(){
		System.out.println("Adjusting stringer");
	}
	public String toString(){
		return "Stringer";
	}
	
}
class Wind implements Instrument {
	public void play(Note n){
		System.out.println("Wind.play() " + n);
	}
	public void adjust(){
		System.out.println("Adjusting wind");
	}
	public String toString(){
		return "Wind";
	}
}
class Percussion implements Instrument{
	public void play(Note n){
		System.out.println("Percussion.play() " + n);
	}
	public void adjust(){
		System.out.println("Adjusting percussion");
	}
	public String toString(){
		return "Percussion";
	}
}
class Brass extends Wind{
	public void play(Note n){
		System.out.println("Brass.play() " + n);
	}

	public String toString(){
		return "Brass";
	}
}
class WoodWind extends Wind{
	public void play(Note n){
		System.out.println("WoodWind.play() " + n);
	}
	
	public String what(){
		return "WoodWind";
	}
}
	

public class Music5 {
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

