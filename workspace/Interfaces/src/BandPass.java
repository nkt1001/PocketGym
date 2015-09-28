public class BandPass extends Filter {
	private double lowCutoff, highCutoff;
	public BandPass(double lc, double hc) {
		// TODO Auto-generated constructor stub
		this.lowCutoff = lc;
		this.highCutoff = hc;
	}
	public Waveform process(Waveform input) {
		// TODO Auto-generated method stub
		return input;
	}
}
