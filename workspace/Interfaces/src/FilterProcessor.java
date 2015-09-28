public class FilterProcessor{
	
	public static void main(String[] args) {
		Waveform w = new Waveform();
		Apply.process(new FilterAdapter(new Lowpass(1.0)), w);
		Apply.process(new FilterAdapter(new Highpass(3.0)), w);
		Apply.process(new FilterAdapter(new BandPass(1.0, 3.0)), w);
	}
}